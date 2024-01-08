import com.google.cloud.tools.jib.gradle.JibExtension

plugins {
  java
  //if we use spring '"3.2.1"' build won't be reproducible anymore.
  // in version 3.1.7 there is no issue
  id("org.springframework.boot") version "3.2.1" apply false
//  id("org.springframework.boot") version "3.1.7" apply false
  id("io.spring.dependency-management") version "1.1.4"
  id("org.sonarqube") version "4.0.0.2929"
  id("com.google.cloud.tools.jib") version "3.4.0" apply false
  jacoco
}


java {
  sourceCompatibility = JavaVersion.VERSION_17
}

allprojects {
  apply(plugin = "java")
  version = System.getenv("CI_COMMIT_REF_SLUG") ?: "0.0.1-SNAPSHOT"

  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "org.sonarqube")
  apply(plugin = "jacoco")
  dependencies {
    testImplementation("org.assertj:assertj-core:3.24.2")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.2")
  }
  tasks.withType<Jar> {
    this.isPreserveFileTimestamps = false
    this.isReproducibleFileOrder = true
  }
  tasks.withType<Test> {
    useJUnitPlatform()
    reports {
      junitXml.required = true
    }
    finalizedBy("jacocoTestReport")
  }
  tasks.withType<JacocoReport> {
    dependsOn(tasks.named("check"))
    reports {
      xml.required = true
      csv.required = true
      html.required = true
    }
  }
}


tasks.register("build-libraries") {
  val librariesProject = project.allprojects - appServices().toSet()
  librariesProject.forEach { projectPath ->
    dependsOn(projectPath.tasks.named("check"))
  }
}

fun appServices(): List<Project> {
  return listOf(project("template-backend"), project("user-backend"))
}

configure(appServices()) {
  apply(plugin = "org.springframework.boot")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "com.google.cloud.tools.jib")

  dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springdoc:springdoc-openapi-ui:1.6.12")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
  }

  configure<JibExtension> {
    val dockerRegistry = getDockerRegistry("CI_REGISTRY_IMAGE")
    to {
      image = "${dockerRegistry}${project.name}:${project.version}"
    }
    from {
      val fromRegistry = getDockerRegistry("CI_DEPENDENCY_PROXY_DIRECT_GROUP_IMAGE_PREFIX")
      image = "${fromRegistry}eclipse-temurin:17-jre@sha256:53b7b641066b6ad46cc97d9356317299eea9b9b0759f8a863b86de564c7672c4"
    }
  }
}




fun getDockerRegistry(env: String): String {
  val registry = System.getenv(env) ?: ""
  return if (registry.isNotBlank()) {
    "$registry/"
  } else {
    registry
  }
}

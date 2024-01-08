dependencies {
  implementation(project(mapOf("path" to ":shared-library")))
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.postgresql:postgresql")
  implementation("org.flywaydb:flyway-core")
}

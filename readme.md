# Spring boot reproducible issue demonstration
### to check if build is reproducible  
Compare the hash manually
```bash
./gradlew -q clean jibBuildTar && md5sum user-backend/build/jib-image.tar \
&&./gradlew -q clean jibBuildTar && md5sum user-backend/build/jib-image.tar
```

if we use spring version 3.1.7 -> md5hash of tar is the same
if we upgrade to 3.2.0 -> md5hash will be different

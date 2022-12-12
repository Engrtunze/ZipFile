#base image
FROM openjdk:17-jdk-slim
LABEL maintainer="John"
ADD build/libs/fileConveter-0.0.1-SNAPSHOT.jar file-compressor.jar
ENTRYPOINT ["java", "-jar", "file-compressor.jar"]
FROM openjdk:14-jdk-oraclelinux7
EXPOSE 8080
ARG JAR_FILE
ADD  ${JAR_FILE} /opt/oracle/app/footballapp.jar
WORKDIR /opt/sapient
ENTRYPOINT ["java", "-jar", "/opt/sapient/app/footballapp.jar"]

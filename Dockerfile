FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/PrescriptionProject-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} prescription.jar
ENTRYPOINT ["java","-jar","/prescription.jar"]
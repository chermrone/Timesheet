FROM openjdk:8
ADD target/app.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar" , "Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.jar"]
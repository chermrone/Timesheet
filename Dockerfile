FROM openjdk:8
ADD target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.jar Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar" , "Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.jar"]
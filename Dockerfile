FROM openjdk:11
COPY .docker/main.jar main.jar
CMD ["java","-jar","main.jar"]

FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
WORKDIR /app
ENV PORT 82
EXPOSE 82

COPY --from=build /app/redirection-service/target/*.jar /app/redirection-app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar redirection-app.jar
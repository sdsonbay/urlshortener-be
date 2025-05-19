FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk
WORKDIR /app
ENV PORT 81
EXPOSE 81

COPY --from=build /app/shortener-service/target/*.jar /app/shortener-app.jar

ENTRYPOINT exec java $JAVA_OPTS -jar shortener-app.jar
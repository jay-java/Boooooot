FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/bootjsp.war /app/bootjsp.war
CMD ["java", "-jar", "bootjsp.war"]
EXPOSE 9090

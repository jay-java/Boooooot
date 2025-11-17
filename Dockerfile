FROM eclipse-temurin:17-jre
WORKDIR /app
COPY target/bootjsp.war
CMD ["java", "-war", "bootjsp.war"]
EXPOSE 9090

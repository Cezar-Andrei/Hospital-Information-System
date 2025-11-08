from maven:3.9.9-amazoncorretto-17 as builder


copy pom.xml /build/
copy src /build/src/

workdir /build/

run mvn clean install

from amazoncorretto:17.0.17

workdir /app/
copy --from=builder /build/target/pathology-service-0.0.1-SNAPSHOT.jar /app/

cmd ["java", "-jar", "pathology-service-0.0.1-SNAPSHOT.jar"]
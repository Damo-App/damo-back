# 1단계: Gradle로 jar 빌드 (gradle 이미 설치된 이미지 사용 → wrapper 불필요)
FROM gradle:7.6.1-jdk11 AS build
WORKDIR /app
COPY . .
RUN gradle bootJar -x test --no-daemon

# 2단계: 빌드된 jar만 실행 이미지에 복사
FROM eclipse-temurin:11-jre
WORKDIR /app
COPY --from=build /app/build/libs/*-SNAPSHOT.jar /app/app.jar
# 기본 프로필은 server. Railway 환경변수 SPRING_PROFILES_ACTIVE로 덮어쓸 수 있음.
# PORT는 application-server.yml에서 ${PORT}로 바인딩.
# 메모리 플래그: Railway 컨테이너(약 512MB) 한도 내에서 동작하도록 힙/GC/스택 제한 (OOM Kill 방지)
ENTRYPOINT ["sh","-c","java -Dspring.profiles.active=${SPRING_PROFILES_ACTIVE:-server} -XX:MaxRAMPercentage=60.0 -XX:+UseSerialGC -Xss512k -jar /app/app.jar"]

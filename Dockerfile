# 1. 베이스 이미지 선택
FROM openjdk:11

# 2. 필요한 소프트웨어 설치
RUN apt-get update && \
    apt-get install -y git

# 3. 애플리케이션 빌드
WORKDIR /app
RUN git clone https://github.com/lh0156/Project-StockPortfolio
WORKDIR /app/spring-project
RUN ./gradlew build

# 4. 애플리케이션 실행
CMD ["java", "-jar", "/app/spring-project/build/libs/spring-project-0.0.1-SNAPSHOT.jar"]
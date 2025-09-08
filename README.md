# 🌱 HereThere Backend

자바 Spring을 기반으로 구현된 **HereThere** 백엔드 애플리케이션입니다.

---

## ⚙ 기술 스택

- Java 17+
- Spring Boot 3.x
- Gradle
- MySQL 8.x
- JPA (Hibernate)

---

## 🚀 프로젝트 실행 방법

### 1. 프로젝트 클론

```bash
git clone https://github.com/herethere-ygjg/backend.git
cd backend
```
### 2. 환경 설정
`src/main/resources/application.properties` 파일을 생성 또는 수정하여 아래와 같이 설정합니다.

```
# 애플리케이션 이름
spring.application.name=hereThere

# MySQL 연결 정보
spring.datasource.url=jdbc:mysql://localhost:3306/herethere?serverTimezone=Asia/Seoul&characterEncoding=UTF-8
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA 설정
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# 서버 포트 (추후 80 으로 수정 예정)
server.port=8080

```
> 현재 mysql 은 각자의 virtualBox 에서 `sudo apt install mysql-server` 을 설치 후 사용해주기 바랍니다 :)

## 📂 프로젝트 구조

```
src/
 ├─ main/
 │   ├─ java/com/herethere/backend/
 │   │    ├─ controller/
 │   │    ├─ service/
 │   │    ├─ repository/
 │   │    └─ entity/
 │   └─ resources/
 │        ├─ application.yml
 │        └─ static/
 └─ test/
 ```

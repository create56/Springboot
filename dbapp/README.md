##DBAPP

###데이터베이스 생성방법
```sql
create user 'korea'@'%' identified by 'korea1234';
GRANT ALL PRIVILEGES ON *.* TO 'korea'@'%';
create database koreadb;
```

###추가 의존성
```xml
	<dependency>
			<groupId>org.apache.tomcat</groupId>
			<artifactId>tomcat-jasper</artifactId>
			<version>9.0.46</version>
	</dependency>
```
### jstl 사용 태그 라이브러리
```xml
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

### Post데이터베이스 생성
```sal
create user 'korea'@'%' identified by 'korea1234';
GRANT ALL PRIVILEGES ON *.* TO 'korea'@'%';
create database koreadb;

SELECT * FROM user;

DESC post;

INSERT INTO post(title, content, user_id) VALUES('제목1','내용',1);
INSERT INTO post(title, content, user_id) VALUES('제목2','내용',1);
INSERT INTO post(title, content, user_id) VALUES('제목3','내용',1);
INSERT INTO post(title, content, user_id) VALUES('제목4','내용',2);

SELECT * FROM post;
```

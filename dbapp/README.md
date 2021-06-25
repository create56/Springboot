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
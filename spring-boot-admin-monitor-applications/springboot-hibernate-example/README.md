# Spring
Q

Example shows to Connect Oracle 12g, Spring boot with Hibernate

Compile and Package the Spring boot Applictaion
```
mvn clean package -DskipTests=true eclipse:eclipse
```
Run the Spring boot application
```
java -jar target\SpringBootHibernate-1.0.0.jar
```
The user can access using the following Web service

http://localhost:8080/users

Technologies Used
```
JDK 1.8
Spring boot 2.0.3.RELEASE
Hibernate 5.3.1.Final
Oracle 12.2.0.1
```
SQL Query in Oracle 12g Database
```
CREATE TABLE Open_User(id INT NOT NULL ,name VARCHAR(255), age int, email  VARCHAR(255));

insert into Open_User (id, name, age, email) values(1,'siva', 31, 's@gmail.com');
insert into Open_User (id, name, age, email) values(2,'selvi', 51, 'kats@gmail.com');
insert into Open_User (id, name, age, email) values(3,'kavitx', 71, 'texrgn@hotmail.com');

select * from Open_User;
```

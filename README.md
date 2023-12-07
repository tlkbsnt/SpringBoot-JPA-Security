
// this is spring-boot web application starter
implementation 'org.springframework.boot:spring-boot-starter-web'
// this is the spring-boot-database starter using the jpa
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
// this is the postgresql database connection dependencies
implementation 'org.postgresql:postgresql:42.7.0'


#Before connect the database 
 need to create the database name 
**  platform: postgres
    driverClassName: org.postgresql.Driver
    url: jdbc:postgresql://localhost:5432/dbSpring
    #dbSpring is a database name
**
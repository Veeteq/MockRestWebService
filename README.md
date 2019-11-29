sources:
https://github.com/eugenp/tutorials/tree/master/persistence-modules/spring-hibernate4
https://www.baeldung.com/hibernate-4-spring
https://sanaulla.info/2017/11/19/configure-embedded-h2-console-with-spring-mvc-application/
https://sanaulla.info/category/spring/
https://javapapers.com/spring/profile-annotation-improvements-in-spring-4/
https://www.youtube.com/watch?v=iCQspqBpOB0&list=PLBgMUB7xGcO31B2gBmy1igpZn6LK78-CJ
https://www.mkyong.com/maven/how-to-deploy-maven-based-war-file-to-tomcat/
https://www.devglan.com/spring-mvc/writing-junit-tests-in-spring4-mvc

#Send file content as JSON
curl -i -X POST -H "Content-Type:application/json" -d @samples/agent.json http://localhost:8282/MockWebService/rest/bso/agent 

https://www.programmableweb.com/apis/directory

#SOAP Web Service
https://github.com/discospiff/JavaFullStackEnterpriseWeb
https://www.youtube.com/watch?v=oeBH6xC5rGY
https://spring.io/guides/gs/producing-web-service/

#Thymeleaf
https://www.thymeleaf.org/doc/articles/thymeleaf3migration.html
https://www.concretepage.com/spring-4/spring-mvc-thymeleaf
https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html

#Deploy 2 Tomcat
mvn clean install tomcat7:deploy -Dspring.profiles.active=xyz

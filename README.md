# Wander user Service.

### About Project structure
* This is a multi module maven spring boot 2 project.
* One is parent project.
* Other one i.e. "*user-service*" a module of Parent project.
* Run below command on parent project.  
````
    mvn clean install
````
* Run main class i.e. "**UserServiceApplication**" from "*user-service*" module.
* Embedded Tomcat server will start on port 5000 on localhost.

### Localhost APIs.
* Below are the APIs:
````
1.  http://localhost:5000/wander/login
2.  http://localhost:5000/wander/register
3.  http://localhost:5000/wander/covid
4.  http://localhost:5000/wander/h2-console/
    Username = sa
    password = password
````

### Public APIs
* Below are the APIS that are publicly available.
````
1.  http://wander-user-uat.eba-ag3zzfvi.us-east-1.elasticbeanstalk.com/wander/login
2.  http://wander-user-uat.eba-ag3zzfvi.us-east-1.elasticbeanstalk.com/wander/register
3.  http://wander-user-uat.eba-ag3zzfvi.us-east-1.elasticbeanstalk.com/wander/covid
````
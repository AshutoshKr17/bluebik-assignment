# bluebik-assignment

**PRE requisites**
  * spring boot
  * Mysql
  * Maven
  * Java 11

## Local Setup Step by Step -

1. First Download Demo File into your System.
2. Then first run DemoApplication.java so that Maven can download all the required dependencies.
3. Set-up MySql for database.
4. Make sure you have mysql and mysql workbench installed in your system.
5. Create a database in MySql using MySql workbench named users or you can name it anything but then you have to modify code accordingly.
6. Once You are done creating a databse using CREATE DATABASE databasename; here databse name should be users.
7. Now when your database is up and running run the DemoApplication again it will create all the required table and columns as per user model defined in your code which is placed in java>com.example.demo>model>User.
8. ChecK that You tables are there in the users database.
9. Once you have table and columns.You have to edit Your application.properties file.
10. You can find application.properties under demo/src/main/resources/application.properties. 
11. Now edit this file in data source url put your datasource url which will look like this if you are using localhost jdbc:mysql://localhost:3306/users?useSSL=false.
12. Edit the username and password as per your mysql databse here my database username is admin and password is Password@123.
13. Edit the jpa dialect and jpa hibernate ddl .. jpa dialect is how you want jpa to convert your data from database.
14. Check the port and url carefully it's important.
15. onece you are done setuping up..good to go and you can perfom and rest api calls using postman.
16. To make api calls the default html tag is for all calls is  http://localhost:8080/api/users you can see that in url there is something 8080 .this is port no where your spring boot application is hosted.

## API CALLS :-

1.To save user or create new user :</br>
  url : http://localhost:8080/api/users </br>
  mapping : Post </br>
  body : user model data in the form of json. </br>
  
2.To getAll users details: </br> 
  url : http://localhost:8080/api/users 
  mapping : Get
  
3.To Search user using a pattern </br>
  url : http://localhost:8080/api/users/search?pattern={pattern} </br>
  mapping : Get </br>
  for eg:If you want to search some names start with ABC. </br>
        url: http://localhost:8080/api/users/search?pattern=ABC </br>

4.To update User using id: </br>
  url : http://localhost:8080/api/users/{id} </br>
  mapping : Put </br>
  body : user model data in the form of json.</br>
  for eg: If you want to update user with id 5.</br>
          url: http://localhost:8080/api/users/5</br>
          
5.To delete User with an id:</br>
  url : http://localhost:8080/api/users/{id}</br>
  mapping : Delete</br>

6.To create user in batch:</br>
  url:http://localhost:8080/api/users/batch</br>
  mapping: post</br>
  body: array of user model in the form of json</br>
  
  for eg: url: http://localhost:8080/api/users/batch</br>
          ```json:
          [
            {
                "firstName": "Ashutosh kumar",
                "lastName": "Kushwaha",
                "email": "rem1@gmail.com",
                "mobNumber": "87000000",
                "gender": "male",
                "creation_date": "12thMarch"
            },```</br>
            
            ```{
                "firstName": "Ashutosh kumar",
                "lastName": "Kushwaha",
                "email": "rem1@gmail.com",
                "mobNumber": "87000000",
                "gender": "male",
                "creation_date": "12thMarch"
            },```</br>
            
            ```{
                "firstName": "Ashutosh kumar",
                "lastName": "Kushwaha",
                "email": "rem1@gmail.com",
                "mobNumber": "87000000",
                "gender": "male",
                "creation_date": "12thMarch"
            }
          ]```
  
7.To delete Multiple User in a bulk using ids:</br>
  url : http://localhost:8080/api/users/bulk/{ids}</br>
  mapping : Delete</br>
  for eg: if you want to delete user having ids [1 5 7 8].</br>
          url: http://localhost:8080/api/users/bulk/1,5,7,8</br>
          
8.To update multiple User in a batch using ids:</br>
  url : http://localhost:8080/api/users/bulk/{ids}</br>
  mapping : Put</br>
  body : user model data in the form of json with updated details.</br>
  
  for eg: if you want to update user having ids [1 5 7 8].</br>
          url: http://localhost:8080/api/users/bulk/1,5,7,8</br>
          ```json:
          {
              "firstName": "Ashutosh kumar",
              "lastName": "Kushwaha",
              "email": "rem1@gmail.com",
              "mobNumber": "87000000",
              "gender": "male",
              "creation_date": "12thMarch"
          }```
      

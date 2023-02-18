# MedClinic

This website can be used by hospitals for booking appointments of patients.
 
 Technical stack used here-> 
 
 Frontend Technologies -> HTML,CSS ,JavaScript, JQuery

Backend Technologies -> Java

Database connectivity driver- Java database connectivity driver

Server- tomcat

On the very first page ,login page will be displayed, if you have the account ,enter the login credentials , 
Home page will be displayed ,On the home Page following features are available->

1)	Book an appointment
2)	Appointment List
3)	Cancel the Appointment

On Clicking Book an appointment ,form will be presented in which you have to enter the personal details and doctor name,time ,at the end appointment will be booked

On clicking ,Appointment List, all appointment of the present day will be displayed.

On clicking ‘Cancel the Appointment ’,you will be taken to the new page,where you have to enter ‘Aaadhar Card Number ’  of that particular patient to cancel his/her appointment.

What happens in the background ->

All the servlet mappings has been done in web.xml
When you will click on login button, in the  background, Using jquery ,username and password will be fetched , a json will be made which contains “{username:’”,password:”” }” a GET type request will be sent to server, with url   “jq/login” ,this request will be entertained by the Login servlet . In login servlet ,username and password will be taken out form the request object After that using method getmethodByUserName of AdministratorDAO ,validation on username and password will be performed  ,in the database username and password will be checked , if username doesn’t’t exist then “INVALID Username”,will be sent in the response from the server side and vice versa for password.
If username and password is correct ,in response ‘1’  will be sent to the client side ,after that on Client Side,in sessionStorage ,login will be set with string “login” . Whenever someone access without doing  login ,then in that case ,  a function will called before loading of the DOM,in that function,login value will checked in sessionSotrage ,if session storage is returning ‘NULL’ then in that scenario ,you will directed to the Login Page.

When we are on ‘HOME PAGE '

For the first functionality  “Book an appointment”, when we click on it, we will be taken to the ‘Appointment Form’ ,where we have to enter personal details ,doctor Name,appointment Time etc.
When we click on ‘Book’ button    ,all the data of the form will be fetched using jquery . a get type request with url  "/jq/addPatient" will be sent to server side using jquery with json which contain the information of the form. As per web.xml servlet mappings  , "/jq/addPatient" this request of the client side  will be handled by  addPatient.java servlet , In that servlet  from the request Object all the data will be taken out ,all the data will be stored in the PatientDTO object.  aadharCardNumberExists(aadharCardNumber) method of PatientDAO will be called where we will pass addharCardNumber ,In this method aadharCardNumber will be checked in the database ,if it exists ,then response “aadharCard Number already exists” will be sent to the client side.If addharCardNumber doesn’t exist then add method of PatientDAO will be called ,as an argument where we pass  will patientDTO object as the argument  ,in this  method , data will be inserted into the database, In response (“1”)  will be sent to the client side. Then we will be redirected to the page “The Appointment booked successfully ”. 


For the second option  that is “Appointment List”,
On clicking on it , we will be taken to eg7.html,before loading of the DOM , a get type request with url  "/jq/patient" will be send to server side using jqeury .As per web.xml servlet mapping this request will be handled by the ‘Patient.java’ ,where patientDAO object will be made .Its ‘getAll()’ method will be called ,which will fetch all data from the database   and will return list type data structure .That list type Data structure will be send to client side using Println method of printWriter.At the client side ,that data will inserted into table.


For the third Option ->Cancelling the Appointment ,
on clicking on it,you will be redirected to the new page that is eg8.html ,where you have to enter andharCardNumber of the person whose appointment you want to cancel. After entering the addharCardNumber On  clicking yes Button ,a GET   type request with url "/jq/deletePatient" using jquery will be send to the server side. According to the servlet mapping done in web.xml ,this request will handled by the deletePatient.java servlet ,where  aadharCardNumber value will be taken out from the request type object ,PatientDAO object will be formed. Delete method of PatientDAO will be called  where it will check  whether addharCardNumber exists   or not ,if exists ,then that particular appointment with addharCardNumber value  will be deleted from the database  .In response 1 will be send on successful deletion to client side   ,and you will be directed  to the page where you will be shown “Appointment Cancelled Successfully”.

When you click on Logout , “login” will be removed from sessionStorage. you will be taken to the login page.


![p1](https://user-images.githubusercontent.com/62482950/219866521-ee295140-9412-4064-8775-5f05ce249901.png)

![p2](https://user-images.githubusercontent.com/62482950/219866551-1b7787b3-dcfb-44be-b40b-218d625f239f.png)

![p3](https://user-images.githubusercontent.com/62482950/219866559-65a09010-485c-4abe-bdb2-0f6014a6da54.png)

![p4](https://user-images.githubusercontent.com/62482950/219866569-a1223dc0-ff0f-4f26-95a3-41479c254c79.png)

![p5](https://user-images.githubusercontent.com/62482950/219866581-c6361049-1d0e-4921-86c2-c9d778fd91df.png)

![p6](https://user-images.githubusercontent.com/62482950/219866589-e70db9c8-59c5-4401-a553-e4322b163e7f.png)








 

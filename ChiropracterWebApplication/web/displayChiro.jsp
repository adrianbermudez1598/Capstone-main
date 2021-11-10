<%-- 
    Document   : displayChiro
    Created on : Sep 4, 2021, 2:26:28 PM
    Author     : kerds
--%>
<%@ page import="Business.Chiropractor"%>
<%@ page import="Business.DbAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta name="viewport" charset="UTF-8" content="width=device-width, initial-scale=1, shrink-to-fit=yes">

   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
        <title>Chiropractor</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <%-- Get the Chiro object c1 out of the Session  --%>
        <jsp:useBean id="d1" scope="session" class="Business.DbAccess"/>
   <body style="background-color: #fff1da; width: 100%; " >
    <header class="sticky-top shadow">

<nav class="navbar navbar-expand-lg" style="background-color: #ff6991">
  <div class="container">
   
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav ms-auto">
      
        
          <ul>
            <li><a href="adminLoginPage.jsp">Home</a></li>
            <li><a href="patientLoginPage.jsp">Patient Login</a></li>
            <li><a href="chiroLoginPage.jsp">Chiropractor Login</a></li>
           
          </ul>
        
      </ul>
    </div>
  </div>
</nav>
</header>
       
        <div class="jumbotron jumbotron-fluid" style="background-image: url('header.jpeg');
   background-size: cover;
   background-repeat: no-repeat;
   height: 800px;
   ">
  <div class="container"  >
      <div class ="row p-5 rounded-lg m-2">
          <div class="col">
      <h1 class="display-2" ><img src="doctor.JPG" style="float:left; width: 75%;       
border-radius: 25px;
  border: 2px solid #ff6991;
  padding: 20px;" ></h1>
      
          </div>
           <div class="col"  style="float: right;">
               <h4>I am dedicated to making your pain... GO AWAY!</h4>
           </div>
    </div>
  </div>
</div>
        <h1>Chiropractor Display</h1>
          <ul>
                <li><a href="chiroHub.jsp">Patient Home</a></li>
                <li><a href="chiroViewAppointment.jsp">View Appointment</a></li>
                <li><a href ="#">Blank 2</a></li>
                <li><a href="displayChiro.jsp">My Information</a></li>
            </ul>
        <h2>Chiropractor ID : <%=d1.c1.getChiropractorID() %> </h2>
        <h2>Name : <%=d1.c1.getChiropractorFirstName() + " " + d1.c1.getChiropractorLastName()%>   </h2>
        <h2>Email : <%=d1.c1.getChiropractorEmail()%> </h2>
        <h2>Phone : <%=d1.c1.getChiropractorPhone() %> </h2>
        
        <footer class="text-center text-white fixed-bottom" style="background-color: #ff6991; width: 100%;">
  
  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: #ff6991;">
      <p class="text-dark">© 2020 Copyright:</p>
    <a  href="index.jsp">www.doctorchiropractorllc.com</a>
  </div>
  <!-- Copyright -->
</footer> 
    </body>
</html>

<%-- 
    Document   : chiroViewAppointment
    Created on : Sep 16, 2021, 1:26:07 PM
    Author     : Jaru

--%>

<%@ page import="Business.Appointments"%>
<%@ page import="Business.AppointmentsList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta name="viewport" charset="UTF-8" content="width=device-width, initial-scale=1, shrink-to-fit=yes">

   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
        <title>JSP Page</title>
        <link rel="stylesheet" href="style.css">
    </head>
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
         <h1>View Appointment</h1>
        <ul>
            <li><a href="chiroHub.jsp">Chiropractor Home</a></li>
            <li><a href="chiroViewAppointment.jsp">View Appointment</a></li>
            <li><a href ="#">Blank 2</a></li>
            <li><a href="displayChiro.jsp">My Information</a></li>
        </ul>
         <% 
            int count = d1.aList.count;      
        %>
        <h2>Appointments: <%= count %></h2>
           <%
       {
           for (int x = 0; x<count; x++){
               String an = d1.aList.appArr[x].getAppointmentNumber();
               String ci = d1.aList.appArr[x].getChiroId();
               String cn = d1.aList.appArr[x].getChiroName();
               String pi = d1.aList.appArr[x].getPatId();
               String pn = d1.aList.appArr[x].getPatName();
               String dt = d1.aList.appArr[x].getMonth() + " " + d1.aList.appArr[x].getDay()+ " " + d1.aList.appArr[x].getYear();
               String month = d1.aList.appArr[x].getMonth();
               String day = d1.aList.appArr[x].getDay();
               String year = d1.aList.appArr[x].getYear();
       %>
        
       
        <br>
        <h2>Appointment Number: <%= an %></h2>
        <h2>Chiropractor ID: <%= ci %></h2>
        <h2>Chiropractor Name: <%= cn %> </h2>
        <h2>Patient ID: <%= pi %> </h2>
        <h2>Patient Name: <%= pn %></h2>
        <h2>Date: <%= dt %> </h2>
        <a href = "chiroDeleteServlet?id=<%=an%>&cid=<%=ci%>"><button>delete</button></a>
        <a href = "chiroEditPage.jsp?an=<%=an%>&cid=<%=ci%>&cn=<%=cn%>&pid=<%=pi%>&pn=<%=pn%>&month=<%=month%>&day=<%=day%>&year=<%=year%>"><button>edit</button></a>
        <br>
        <%}
            }   %>
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

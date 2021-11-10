<%-- 
    Document   : ChiroEditPage
    Created on : Oct 8, 2021, 12:10:32 AM
    Author     : lalu
--%>
<%
    String an =request.getParameter("an");
    String cid =request.getParameter("cid");
    String cn =request.getParameter("cn");
    String pid =request.getParameter("pid");
    String pn =request.getParameter("pn");
    String month =request.getParameter("month");
    String day =request.getParameter("day");
    String year =request.getParameter("year");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" charset="UTF-8" content="width=device-width, initial-scale=1, shrink-to-fit=yes">

   
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
        <title>Edit Appointment</title>
    </head>
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
        <form action="chiroEditServlet" method="POST" id="aligned">
            <h2>
            <label> Appointment Number: <%= an %></label><br>
            <label> Chiropractor ID: <%= cid %></label><br>
            <label> Chiropractor Name: <%= cn %></label><br>
            <label> Patient ID: <%= pid %></label><br>
            <label> Patient Name: <%= pn %></label><br>
            <input type="hidden" name="an" value =<%= an %>><br>
            <input type="hidden" name="cid" value =<%= cid %>><br>
            <input type="hidden" name="cn" value =<%= cn %>><br>
            <input type="hidden" name="pid" value =<%= pid %>><br>
            <input type="hidden" name="pn" value =<%= pn %>><br>
            <label>Month</label>
            <input type="text" name="month" value =<%= month %>><br>
            <label>Day</label>
            <input type="text" name="day" value=<%= day %>><br>
            <label>Year</label>
            <input type="text" name="year"value=<%= year %>><br>
            <input type="submit" value="Update"><br>
            </h2>
        </form>
            <a href="chiroViewAppointment.jsp">Back</a>
            
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
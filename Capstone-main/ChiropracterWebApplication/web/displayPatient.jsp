<%-- 
    Document   : displayPatient
    Created on : Sep 9, 2021, 2:59:32 PM
    Author     : Jaru
--%>

<%@page import="Business.Patient"%>
<%@page import="Business.DbAccess"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient</title>
        <link rel="stylesheet" href="style.css">
    </head>
        <jsp:useBean id="d1" scope="session" class="Business.DbAccess"/>
    <body>
        <h1>My Information</h1>
          <ul>
            <li><a href="patientHub.jsp">Patient Home</a></li>
            <li><a href="patientViewAppointment.jsp">View Appointment</a></li>
            <li><a href="#">Make An Appointment</a></li>
            <li><a href ="#">Cancel An Appointment</a></li>
            <li><a href="displayPatient.jsp">My Information</a></li>
            </ul>
        <h2>Patient ID: <%=d1.p1.getPatientID()%></h2>
        <h2>Name: <%=d1.p1.getPatientFirstName() + " "+ d1.p1.getPatientLastName()%></h2>
        <h2>Email: <%=d1.p1.getPatientEmail()%> </h2>
        <h2>Phone: <%=d1.p1.getPatientPhone()%> </h2>
    </body>
</html>

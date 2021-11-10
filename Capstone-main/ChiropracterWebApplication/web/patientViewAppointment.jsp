<%-- 
    Document   : patientViewAppointment
    Created on : Sep 10, 2021, 12:26:32 PM
    Author     : Jaru
--%>
<%@page import="Servlets.patientLoginServlet"%>
<%@page import="Business.Appointments"%>
<%@page import="Business.DbAccess"%>
<%@page import="Servlets.patientViewAppointmentServlet" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient View Appointment</title>
        <link rel="stylesheet" href="style.css">
    </head>
     <jsp:useBean id="d1" scope="session" class="Business.DbAccess"/>
     <FORM Name="patientAppointment" ACTION="patientViewAppointmentServlet">
         </form>
    <body>
        <h1>Appointment</h1>
        <ul>
            <li><a href="patientHub.jsp">Patient Home</a></li>
            <li><a href="patientViewAppointment.jsp">View Appointment</a></li>
            <li><a href="#">Make An Appointment</a></li>
            <li><a href ="#">Cancel An Appointment</a></li>
            <li><a href="displayPatient.jsp">My Information</a></li>
        </ul>
        <h2>Appointment Number: <%=d1.a1.getAppointmentNumber()%></h2>
        <h2>Chiropractor ID: <%=d1.a1.getChiroId() %></h2>
        <h2>Chiropractor Name: <%=d1.a1.getChiroName() %> </h2>
        <h2>Patient ID: <%=d1.a1.getPatId()%> </h2>
        <h2>Patient Name: <%=d1.a1.getPatName()%></h2>
        <h2>Date: <%=d1.a1.getMonth() + " " + d1.a1.getDay()+ " " + d1.a1.getYear()%> </h2>
    </body>
</html>

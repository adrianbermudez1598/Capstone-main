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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chiropractor</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <%-- Get the Chiro object c1 out of the Session  --%>
        <jsp:useBean id="d1" scope="session" class="Business.DbAccess"/>
    <body>
        <h1>Display Here</h1>
        <h1>Chiropractor Display</h1>
          <ul>
                <li><a href="chiroHub.jsp">Patient Home</a></li>
                <li><a href="#">Blank 1</a></li>
                <li><a href ="#">Blank 2</a></li>
                <li><a href="displayChiro.jsp">My Information</a></li>
            </ul>
        <h2>Chiropractor ID : <%=d1.c1.getChiropractorID() %> </h2>
        <h2>Name : <%=d1.c1.getChiropractorFirstName() + " " + d1.c1.getChiropractorLastName()%>   </h2>
        <h2>Email : <%=d1.c1.getChiropractorEmail()%> </h2>
        <h2>Phone : <%=d1.c1.getChiropractorPhone() %> </h2>
    </body>
</html>

<%-- 
    Document   : adminLoginPage
    Created on : Sep 4, 2021, 2:25:10 PM
    Author     : kerds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
           <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Hello World!</h1>
         <ul>
            <li><a href="index.jsp">Home</li>
            <li><a href ="#">About</li>
            <li class="login">
                <a href ="#" class="loginBtn">Login</a>
                    <div class="loginContent">
                        <a href="adminLoginPage.jsp">Admin</a>
                        <a href="chiroLoginPage.jsp">Chiropractor</a>
                        <a href="patientLoginPage.jsp">Patient</a>
                    </div>
            </li>
        </ul>
    </body>
</html>

<%-- 
    Document   : chiroLoginPage
    Created on : Sep 4, 2021, 1:29:49 PM
    Author     : kerds
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chiropractor Login</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <FORM Name="index" ACTION="chiroLoginServlet"> 
    <body>
        <h1>Login</h1>
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
    <form method="post">
        
      <input type="text" name="userID" placeholder="User ID" required="required" />
        <input type="password" name="passWord" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Login</button>
    </form>
</html>

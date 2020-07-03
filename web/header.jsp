<%-- 
    Document   : header
    Created on : 20 Jun, 2020, 11:30:51 AM
    Author     : RUSHABH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
        <style>#hey{font-size: 16px;color: lightblue;   padding-top: 7px;}</style>
        <style>#hey1{position: fixed;  right: 45px;   top: 12px;}</style>
        <style></style>            
    </head>
    <body>

        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires", "0");

            String usrname = (String) session.getAttribute("username");
            if (usrname == (null) || usrname.trim().equals("")) {   %>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="home.jsp">BlogSite</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="signup.jsp">SignUp</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Login</a>
                </li>
            </ul>
        </nav>
        <%  } else {%>

        <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
            <!-- Brand/logo -->
            <a class="navbar-brand" href="home.jsp">BlogSite</a>

            <!-- Links -->
            <ul class="navbar-nav">
                <li class="nav-item" id="hey">
                    Welcome <%= usrname%>&nbsp&nbsp
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="home.jsp">Home</a>
                </li>                
                <li class="nav-item">
                    <a class="nav-link" href="addpost.jsp">Post</a>
                </li>
                <li class="nav-item" id="hey1">
                    <form action="logout" method="get">
                        <input type="submit" value="Logout">
                    </form>
                </li>

            </ul>
        </nav>
        <% }%>

    </body>
</html>

<%-- 
    Document   : login
    Created on : 20 Jun, 2020, 11:44:06 AM
    Author     : RUSHABH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login Page</title>
    </head>
    <body style="background-color:lightgoldenrodyellow;">

        <%--To check if user is already logged-in if so then redirect to home page--%>
        <%

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires", "0");

            String usrname = (String) session.getAttribute("username");
            if (usrname != (null)) {
                response.sendRedirect("home.jsp");
            } else {    %>

        <jsp:include page="header.jsp"/>

    <center>
        <h2>Welcome User!</h2>
        <br>

        <form action="login" method="post">

            Username: <input type="text" name="username" placeholder="Username"><br><br>

            Password: <input type="password" name="password" placeholder="Password"><br><br>

            <input type="submit" value="submit">

        </form>
        <br>
        <h5>New here...? <a href="signup.jsp">Click here to Register</a></h5>
    </center>
    <% }%>
</body>
</html>

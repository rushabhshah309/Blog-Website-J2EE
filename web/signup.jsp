<%-- 
    Document   : signup
    Created on : 20 Jun, 2020, 11:41:40 AM
    Author     : RUSHABH
--%>
<!DOCTYPE html>
<html>
    <head>
        <title>signup page</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="background-color:lightgoldenrodyellow;">

        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires", "0");

            String usrname = (String) session.getAttribute("username");
            if (usrname != (null)) {
                response.sendRedirect("home.jsp");
            } else {   %>

        <jsp:include page="header.jsp"/>

    <center>
        <h1 align="center"><u>User Registration</u></h1><br>
        <h4>Enter your details below</h4><br>

        <form action="register" method="post">
            First name <input type="text" name="firstname" placeholder="First Name"><br><br>

            Username: <input type="text" name="username" placeholder="Username"><br><br>

            Email <input type="Email" name="email" placeholder="Email"><br><br>

            Password: <input type="Password" name="password" placeholder="Password"><br><br>

            Conform Password: <input type="Password" name="cpassword" placeholder="Conform Password"><br><br>

            <input type="submit" value="submit">

        </form> 
    </center>

    <% }%>

</body>
</html>

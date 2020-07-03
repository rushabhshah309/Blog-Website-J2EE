<%-- 
    Document   : postadded
    Created on : 29 Jun, 2020, 12:49:05 PM
    Author     : RUSHABH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-color: lightgoldenrodyellow">
        <%

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires", "0");

            String usrname = (String) session.getAttribute("username");
            if (usrname == (null) || usrname.trim().equals("")) {
                response.sendRedirect("home.jsp");
                return;
            }
        %>

    <center>
        <h1>Post added successfully.  :)</h1> 
        <br>
        <h3>To go to home page, click <a href="home.jsp">here</a></h3>
    </center>

</body>
</html>

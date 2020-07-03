<%-- 
    Document   : addpost
    Created on : 27 Jun, 2020, 1:12:46 PM
    Author     : RUSHABH
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add post</title>
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

        <jsp:include page="header.jsp"/>   

    <center>
        <h2>Add a post here..!</h2><br><br>

        <form action="added" method="post">
            <h5>Add a title</h5>
            <input type="text" name="title" placeholder="add a title"> <br><br><br>

            <h5>Add brief description here</h5>
            <textarea rows="5" cols="50" name="descrip" placeholder="add description here"></textarea><br>

            <input type="submit" value="add">
        </form>

    </center>

</body>
</html>

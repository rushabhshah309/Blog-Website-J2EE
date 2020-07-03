<%-- 
    Document   : home
    Created on : 20 Jun, 2020, 11:35:23 AM
    Author     : RUSHABH
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="database.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home Page</title>
        <style>
            h3{color: brown;}
            h4{color: brown;}
            h5{color: darkslategray;}
            #hh{
                background-color: lightyellow;  width: 660px; position: relative;
                height: auto;  border: 2px solid lightsalmon; 
            }
            div{
                background-color: lightgray;  width: 600px; height: 200px; position: relative;
                display: inline-block; 
                height: auto; border: 5px solid cadetblue;  padding: 10px;
                margin: 20px;}
            </style>
        </head>
        <body style="background-color:lightgoldenrodyellow;">


        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setHeader("Expires", "0");

            String usrname = (String) session.getAttribute("username");
            if (usrname == (null) || usrname.trim().equals("")) { %>

        <jsp:include page="header.jsp"/>

        <br><br><br>
    <center><h3>This is BlogSite's home page...!!<br></h3>
        <h4>You can post your Blog by logging into our website.</h4>
    </center>

    <%  } else { %>

    <jsp:include page="header.jsp"/>

    <center>
        <div id="hh">
            <h2>BlogPost</h2>

            <%
                Connection con = DBConnector.getNewConnection();
                Statement st = con.createStatement();

                String query = "select * from post order by id desc";

                ResultSet rs = st.executeQuery(query);
                String username;
                String title;
                String description;
                String time;
                while (rs.next()) {

                    username = rs.getString("username");
                    title = rs.getString("title");
                    description = rs.getString("description");
                    time = rs.getString("time");

            %>

            <center>
                <div>
                    <h3><%= title%></h3>  
                    <%= time%>
                    <h5><%= description%></h5>                
                    -by <%= username%>

                </div>
            </center>


            <%}

            %>

            <% }%>

        </div>
    </center>

</body>
</html>

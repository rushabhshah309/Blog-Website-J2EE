/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFiles;

import database.DBConnector;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author RUSHABH
 */
//@WebServlet(name = "AddPostInDB", urlPatterns = {"/AddPostInDB"})
@WebServlet("/added")
public class AddPostInDB extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("addpost.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("descrip");

        if (title.isEmpty() || description.isEmpty()) {
            response.sendRedirect("addpost.jsp");
        } else {
            try {
                Connection con = DBConnector.getNewConnection();
                Statement st = con.createStatement();

                HttpSession session = request.getSession();
                String usrnam = (String) session.getAttribute("username");

                String query = "insert into post(username, title, description) values(\"" + usrnam + "\",\"" + title + "\",\"" + description + "\");";

                int count = st.executeUpdate(query);

                if (count <= 0) {
                    response.sendRedirect("addpost.jsp");
                } else {
                    response.sendRedirect("postadded.jsp");
                }
            } catch (SQLException ex) {
                System.out.println(ex + "   CATCH BLOCK FROM ADDPOSTINDB");
            }
        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checker;

import auth.LoginAuth;
import java.io.IOException;
import java.io.PrintWriter;
import javaFiles.User;
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
//@WebServlet(name = "LoginChecker", urlPatterns = {"/login"})
@WebServlet("/login")
public class LoginChecker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.isEmpty() || password.isEmpty()) {
            response.sendRedirect("login.jsp");
            //return;   you can also use return instead of else block below so to avoid 'HTTP Status 500 - cannot call sendRedirect() after the response has been commited'
        } else {
            User u = new User();
            u.setUname(username);
            u.setPasword(password);

            LoginAuth userLogin = new LoginAuth();
            boolean login = userLogin.isLogin(u);

            if (login) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("home.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }
        }
    }

}

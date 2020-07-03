/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checker;

import auth.RegistrationAuth;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaFiles.User;
import javaFiles.UserDAO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(name = "RegistrationChecker," urlPatterns = {"/register"})
@WebServlet("/register")
public class RegistrationChecker extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://localhost:8080/MyProject/signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cpassword = request.getParameter("cpassword");

        if (!password.equals(cpassword) || firstname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
            response.sendRedirect("http://localhost:8080/MyProject/signupfailed.jsp");
        } else {
            //UserDAO dao = new UserDAO();
            User u = new User();
            u.setFname(firstname);
            u.setUname(username);
            u.setMail(email);
            u.setPasword(password);

            RegistrationAuth userRegister = new RegistrationAuth();
            try {
                boolean isReg = userRegister.isRegister(u);

                if (isReg) {
                    response.sendRedirect("http://localhost:8080/MyProject/login.jsp");
                } else {
                    response.sendRedirect("http://localhost:8080/MyProject/signupfailed.jsp");
                }

            } catch (Exception ex) {
                System.out.println(ex + "   CATCH BLOCK FROM REGISTRATIONCHECKER");
            }
        }
    }

}

//            try {
//                dao.connect();
//            } catch (Exception ex) {
//                System.out.println(ex + "    catch of connect");
//            }
//            
//            try {
//                dao.addUser(u);
//            } catch (Exception ex) {
//                System.out.println(ex + "   catch of adduser");
//            }
//            
//            response.sendRedirect("http://localhost:8080/MyProject/login.jsp");

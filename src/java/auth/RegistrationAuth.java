/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import database.DBConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javaFiles.User;

/**
 *
 * @author RUSHABH
 */
public class RegistrationAuth {

    public boolean isRegister(User u) throws SQLException {

        String DBName = "user";

        String username = u.getUname();
        String firstname = u.getFname();
        String email = u.getMail();
        String password = u.getPasword();

        username = username.trim();
        firstname = firstname.trim();
        email = email.trim();
        password = password.trim();

        try {
            Statement st = DBConnector.getStatement();
            Connection con = DBConnector.getConnection();

            String query = "CREATE DATABASE IF NOT EXISTS " + DBName;

            st = con.createStatement();
            int result = st.executeUpdate(query);

            if (result > 0) {
                con = DBConnector.getNewConnection();

                String query1 = "CREATE TABLE registration ("
                        + "firstname varchar(20),"
                        + "username VARCHAR(15) NOT NULL,"
                        + "email varchar(25) NOT NULL,"
                        + "password varchar(20),"
                        + "CONSTRAINT pk_registration PRIMARY KEY (username, email)  );";

                st = con.createStatement();
                int result1 = st.executeUpdate(query1);  //Table Created!

            }

            con = DBConnector.getNewConnection();
            st = con.createStatement();
            String query1 = "select username from registration where username= \"" + username + "\" ";//checking if username is already registered.                     
            ResultSet rs = st.executeQuery(query1);

            if (rs.next()) {
                return false;
            }

            String query2 = "select email from registration where email= \"" + email + "\" ";//checking if email is already registered.            
            rs = st.executeQuery(query2);

            if (rs.next()) {
                return false;
            }

            //con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");
            String query3 = "INSERT INTO registration VALUES (?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query3);
            pst.setString(1, firstname);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, password);
            int result2 = pst.executeUpdate();

            if (result2 > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e + "    CATCH BLOCK FROM REGISTERAUTH");
        }

        return false;

    }
}

//        try {
//            String query = "CREATE DATABASE IF NOT EXISTS user";
//
//            st = con.createStatement();
//            int result = st.executeUpdate(query);
//
//            if (result > 0) {
//                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");
//
//                String query1 = "CREATE TABLE registration ("
//                        + "firstname varchar(20),"
//                        + "username VARCHAR(15) NOT NULL,"
//                        + "email varchar(25),"
//                        + "password varchar(20),"
//                        + "PRIMARY KEY (username) );";
//
//                st = con.createStatement();
//                int result1 = st.executeUpdate(query1);
//
//            }
//
//            int temp = checkUser(u.uname);
//            if (temp == 1) {
//                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");
//                String query3 = "INSERT INTO registration VALUES (?,?,?,?);";
//                PreparedStatement pst = con.prepareStatement(query3);
//                pst.setString(1, u.fname);
//                pst.setString(2, u.uname);
//                pst.setString(3, u.mail);
//                pst.setString(4, u.pasword);
//                pst.executeUpdate();
//            }
//            else{
//                
//            }
//        } 
//        catch (Exception e) {
//            System.out.println(e + "  catch from main");
//        }
//    public int checkUser(String username) throws SQLException {
//        String query4 = "select firstname from registration where username= \"" + username + " \"  ";
//
//        try {
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(query4);
//            int count = 0;
//            while (rs.next()) {
//                count++;
//            }
//            if (count == 0) {
//                return 1;
//            } else {
//                return 0;
//            }
//        } catch (Exception e) {
//        }
//        return 0;
//    }
//
//}

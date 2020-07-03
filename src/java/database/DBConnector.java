/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RUSHABH
 */
public class DBConnector {

    static Connection con = null;
    static Statement st = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=IST", "root", "");
            Statement st = con.createStatement();
        } catch (Exception ex) {
            System.out.println(ex + "   CATCH BLOCK FROM DBCONNECTOR!");
        }
    }

    public static Statement getStatement() {
        return st;
    }

    public static Connection getConnection() {
        return con;
    }

    public static Connection getNewConnection() throws SQLException {
        String DBName = "user";
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBName + "?serverTimezone=IST", "root", "");
        return con;
    }

}

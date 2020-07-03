/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auth;

import database.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javaFiles.User;

/**
 *
 * @author RUSHABH
 */
public class LoginAuth {

    public boolean isLogin(User u) {
        String username = u.getUname();
        String password = u.getPasword();

        String query = "select username from registration where username = \"" + username + "\" and password = \"" + password + "\" ";

        try {

            Connection con = DBConnector.getNewConnection();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            int count = 0;
            while (rs.next()) {
                count++;
            }
            if (count == 1) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            System.out.println(e + "    CATCH BLOCK FROM LOGINAUTH");
        }
        return false;
    }
}

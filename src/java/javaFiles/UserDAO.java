package javaFiles;

import java.sql.*;

public class UserDAO {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=IST", "root", "");
    }

    public void addUser(User u) throws SQLException {
        try {
            String query = "CREATE DATABASE IF NOT EXISTS user";

            st = con.createStatement();
            int result = st.executeUpdate(query);

            if (result > 0) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");

                String query1 = "CREATE TABLE registration ("
                        + "firstname varchar(20),"
                        + "username VARCHAR(15) NOT NULL,"
                        + "email varchar(25),"
                        + "password varchar(20),"
                        + "PRIMARY KEY (username) );";

                st = con.createStatement();
                int result1 = st.executeUpdate(query1);

            }

            int temp = checkUser(u.uname);
            if (temp == 1) {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");
                String query3 = "INSERT INTO registration VALUES (?,?,?,?);";
                PreparedStatement pst = con.prepareStatement(query3);
                pst.setString(1, u.fname);
                pst.setString(2, u.uname);
                pst.setString(3, u.mail);
                pst.setString(4, u.pasword);
                pst.executeUpdate();
            } else {

            }
        } catch (Exception e) {
            System.out.println(e + "  catch from main");
        }

    }

    public int checkUser(String username) throws SQLException {
        String query4 = "select firstname from registration where username= \"" + username + " \"  ";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?serverTimezone=IST", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query4);
            int count = 0;
            while (rs.next()) {
                count++;
            }
            if (count == 0) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }
        return 0;
    }

}

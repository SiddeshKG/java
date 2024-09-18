
package org.example;
import org.postgresql.Driver;

import java.net.URL;
import java.sql.*;

public class JdbcConn {

    /*
    import package
    load and register
    create connection
    Create statement
    Execute statement
    process results
    close connection

     */

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        String User ="postgres";
        String pwd ="Siddu2525";
        String url ="jdbc:postgresql://localhost:5433/JDBCdemo";
        String querry="";
        Class.forName("org.postgresql.Driver");
        // driver has benn uploaded
      Connection con= DriverManager.getConnection(url,User,pwd);
      //connection is done
        System.out.println("connection established");
        //creating statement
        Statement st = con.createStatement();
        //executing queery
        ResultSet rs=st.executeQuery(querry);

    }
}

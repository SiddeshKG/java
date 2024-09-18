package org.example;

import java.sql.*;

public class JdbcFetch {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/demo";
        String User ="postgres";
        String pwd ="Siab@2528";
        String querry="SELECT * FROM public.student where sname = 'shyam'";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,User,pwd);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(querry);
            while (res.next())
            {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
            }



        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

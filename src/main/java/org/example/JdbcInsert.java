package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcInsert {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/demo";
        String user= "postgres";
        String pwd ="Siab@2528";
        String querry ="INSERT INTO public.student(\"Sid\", sname, \"Marks\")VALUES (6, 'nyam', 88);";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement st = con.createStatement();
            st.execute(querry);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

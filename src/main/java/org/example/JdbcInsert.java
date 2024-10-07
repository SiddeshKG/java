package org.example;

import java.sql.*;
import java.util.Scanner;

public class JdbcInsert {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/demo";
        String user= "postgres";
        String pwd ="Siab@2528";
        String querry ="INSERT INTO public.student(\"Sid\", sname, \"Marks\")VALUES (?, ?, ?);";
        String querry1 ="INSERT INTO public.student(\"Sid\", sname, \"Marks\")VALUES (8, 'nyam', 88);";
        String querry2 ="INSERT INTO public.student(\"Sid\", sname, \"Marks\")VALUES (9, 'nyam', 88);";
        String querry3 ="INSERT INTO public.student(\"Sid\", sname, \"Marks\")VALUES (10, 'nyam', 88);";


        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,user,pwd);
            //prepared statement is used to collect data from user
            //prepared statement takes care of incomplete querry
           PreparedStatement pt =con.prepareStatement(querry);

            Scanner sc = new Scanner(System.in);
            System.out.println("enter number of records to be inserted");
            int n =sc.nextInt();
            con.setAutoCommit(false);//making code to obey consistency

            for(int i=1; i<=n; i++){
                System.out.println("enter id");
                int id = sc.nextInt();
                System.out.println("enter name");
                String sname = sc.next();
                System.out.println("enter marks");
                int Marks = sc.nextInt();

                pt.setInt(1, id);
                pt.setString(2, sname);
                pt.setInt(3, Marks);

                pt.execute();
            }
            con.commit();
            System.out.println("querry executed successfully");
//            Statement st = con.createStatement();
//            st.addBatch(querry1);
//            st.addBatch(querry);
//            st.addBatch(querry2);
//            st.addBatch(querry3);
////batches are created to same number of hard disk hit while executing querry
//            st.executeBatch();
//           // st.execute(querry);
            pt.close();
            con.close();

        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

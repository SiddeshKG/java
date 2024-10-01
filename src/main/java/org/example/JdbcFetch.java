package org.example;

import java.sql.*;

public class JdbcFetch {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/demo";
        String User ="postgres";
        String pwd ="Siab@2528";
        String querry="SELECT * FROM public.student ";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,User,pwd);
            Statement st = con.createStatement();
            ResultSet res = st.executeQuery(querry);

//            while (res.next()) this is feasiable when we know
//            the details about the table most cases w will not be knowing details of table
//            {
//                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
//            }
//             res.first();//takes cursor to first row it will
//            // work only when create statement is given with type scroll sensitive
//            System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
//
//            res.absolute(1);// get values from perticular row
//            System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));


              ResultSetMetaData metadata=res.getMetaData();
              for (int i=1; i<=metadata.getColumnCount(); i++){
                  System.out.println(metadata.getColumnName(i)+" "+ metadata.getColumnTypeName(i));

              }
            while (res.next())
            {
                System.out.println(res.getInt(1) + " " + res.getString(2) + " " + res.getInt(3));
            }
            res.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException |SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

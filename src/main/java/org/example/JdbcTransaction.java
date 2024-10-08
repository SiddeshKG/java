package org.example;

import java.sql.*;
import java.util.Scanner;

public class JdbcTransaction {
    public static void main(String[] args) {
        String url ="jdbc:postgresql://localhost:5432/demo";
        String User ="postgres";
        String pwd ="Siab@2528";
        String querry1 ="SELECT * FROM public.account\n" +
                "where acc_num = ? and pin = ?";

        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(url,User,pwd);
            System.out.println("<-----Welcome to Bank----->");
            Scanner sc = new Scanner(System.in);
            System.out.println("enter account numer");
             int acc_num = sc.nextInt();
            System.out.println("pelase enter pin");
            int pin = sc.nextInt();

            PreparedStatement pstmt = con.prepareStatement(querry1);
            pstmt.setInt(1,acc_num);
            pstmt.setInt(2,pin);

            ResultSet res1=pstmt.executeQuery();
            if(res1.next()) {
                String name = res1.getString(4);
                int balance = res1.getInt(3);
                System.out.println("welcome : " + name + " " + "available balance is : " + balance);
            }
            else {
                System.out.println("please enter valid account number or PIN.");
            }


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

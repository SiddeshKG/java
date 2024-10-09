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
            con.setAutoCommit(false); // Start transaction
            System.out.println("<-----Welcome to Bank----->");
            Scanner sc = new Scanner(System.in);
            System.out.println("enter account number");
             int acc_num = sc.nextInt();
            System.out.println("please enter pin");
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

            //Transaction details from senders bank

            System.out.println("enter receiver bank account details");
            int b_acc=sc.nextInt();
            System.out.println("enter transfer amount");
            int t_amt =sc.nextInt();


            System.out.println("please enter transaction pin");
            int t_pin = sc.nextInt();

            String query2 = "SELECT * FROM public.account WHERE t_pin = ?";

            PreparedStatement pstmt2= con.prepareStatement(query2);
            pstmt2.setInt(1,t_pin);
                ResultSet res2=pstmt2.executeQuery();

            String query3 = "UPDATE public.account SET balance = balance - ? WHERE acc_num = ?";
            if(res2.next()){
                PreparedStatement pstmt3 = con.prepareStatement(query3);
                pstmt3.setInt(1,t_amt);
                pstmt3.setInt(2,acc_num); //sender's acc number
                pstmt3.executeUpdate();

                String query5 = "UPDATE public.account SET balance = balance + ? WHERE acc_num = ?";
                PreparedStatement pstmt5 = con.prepareStatement(query5);
                pstmt5.setInt(1, t_amt);
                pstmt5.setInt(2, b_acc); // Receiver's account number
                pstmt5.executeUpdate();

                String query4 = "SELECT balance FROM public.account WHERE acc_num = ?";
                // Get and display sender's balance
                PreparedStatement pstmt4 = con.prepareStatement(query4);
                    pstmt4.setInt(1,acc_num);
                ResultSet resBal =pstmt4.executeQuery();
                if(resBal.next()){
                int bal =resBal.getInt("balance");

                System.out.println("your existing balance : " +bal);
}
                con.commit();
                System.out.println("transaction successful");
            }
            else {
                System.out.println("invalid transaction pin");
            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

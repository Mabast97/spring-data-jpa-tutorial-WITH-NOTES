package com.dailycodebuffer.spring.data.jpa.tutorial;
import java.sql.Connection;
import java.sql.DriverManager;

public class testConnection {
    public static void main(String[] args) {
            String jdbcUrl = "jdbc:mysql://localhost:3306/?schooldb";
            String user = "hbstudent";
            String pass = "hbstudent";

            try {
                System.out.println("Connecting to database: "+ jdbcUrl);

                Connection myConn =
                        DriverManager.getConnection(jdbcUrl, user, pass);

                System.out.println("Connection Successfull !!!");

            }catch (Exception exc){
                exc.printStackTrace();
            }

    }
}


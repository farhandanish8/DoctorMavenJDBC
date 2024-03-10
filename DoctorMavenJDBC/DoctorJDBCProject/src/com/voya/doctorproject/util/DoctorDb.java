package com.voya.doctorproject.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoctorDb {
    // Database connection parameters
    static final String URL = "jdbc:mysql://localhost:3306/doctor_database";
    static final String USERNAME = "root";
    static final String PASSWORD = "Xworkzodc@123";

    // Method to open a database connection
    public static Connection openConnection() {
        try {


            // Create the connection
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connected to database");
            return connection;
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
            return null; // Return null if connection fails
        }
    }
}

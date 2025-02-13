package tn.esprit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        final String url = "jdbc:mysql://localhost:3306/WorkCrud";
        final String user = "root";
        final String password = "";
        private Connection conn;  //Attribut
        private static DBConnection instance; //Step2: Création d'une variable de même type que la classe

    //Constructor
    //Singleton: Step1: Privatisation du constructeur
    public DBConnection() {
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection established");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Connection getConn() { return conn; }
    //Step3: Check if instance NULL **
    public static DBConnection getInstance() {
        if(instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }
}

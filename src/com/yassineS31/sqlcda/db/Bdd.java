package com.yassineS31.sqlcda.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {
        //Attribut paramètre BDD
        static final String DB_URL = "jdbc:mysql://127.0.0.1:3307/javacda";
        static final String USERNAME = "root";
        static final String PASSWORD = "123";
        //Connexion à la BDD
        private static Connection connexion;
        static {
            try {
                connexion = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        public static Connection getConnexion(){
            return connexion;
        }
    }


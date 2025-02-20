package com.medicare.Dao;

import com.medicare.Dao.ConnectionDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDao {
    private String jdbcURL = "jdbc:mysql://localhost:3306/medicare?useSSL=false";
    private String jdbcUser = "root";
    private String jdbcPassword = "admin";

    public Connection connection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUser, jdbcPassword);
        }
        catch (SQLException e) {
            throw new RuntimeException("Erreur de connexion à la base de données", e);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

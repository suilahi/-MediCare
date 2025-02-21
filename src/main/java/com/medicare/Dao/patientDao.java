  package com.medicare.Dao;

  import com.medicare.Model.RendezVous;
  import com.medicare.Model.patient;

  import java.sql.*;
  import java.util.List;

  public class patientDao {
      public Connection connection(){
          Connection connection = null;
          try {
              Class.forName("com.mysql.cj.jdbc.Driver");
              connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/medicare?useSSL=false", "root", "admin");
          }
          catch (SQLException e) {
              throw new RuntimeException("Erreur de connexion à la base de données", e);
          }
          catch (ClassNotFoundException e) {
              e.printStackTrace();
          }
          return connection;
      }

      public patientDao() {
      }

      public void createRendezVous(patient patient) {
          Connection connection = connection();
          String sql = "INSERT INTO patient ( Username, Email,Tele,Motif) VALUES ( ?, ?, ?,?)";
          try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
              stmt.setString(1, patient.getName());
              stmt.setString(2, patient.getEmail());
              stmt.setString(3, patient.getPhone());
              stmt.setString(4, patient.getMotif());

          stmt.executeUpdate();

          } catch (SQLException e) {
              e.printStackTrace();
          }
      }

  }
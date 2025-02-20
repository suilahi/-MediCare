package com.medicare.Dao;

import com.medicare.Model.RendezVous;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RendezVousDao {
    private Connection connection;

    public RendezVousDao(Connection connection) {
        this.connection = connection;
    }

    public boolean createRendezVous(RendezVous rendezVous) {
        String sql = "INSERT INTO Rendez_vous (Appoinment_Date, Patient_ID, Doctor_ID, time) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDate(1, rendezVous.getAppointmentDate());
            stmt.setInt(2, rendezVous.getPatientId());
            stmt.setInt(3, rendezVous.getDoctorId());
            stmt.setTime(5, rendezVous.getTime());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public RendezVous getRendezVousById(int id) {
        String sql = "SELECT * FROM Rendez_vous WHERE RendV_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new RendezVous(
                        rs.getInt("RendV_ID"),
                        rs.getDate("Appoinment_Date"),
                        rs.getInt("Patient_ID"),
                        rs.getInt("Doctor_ID"),
                        rs.getTime("time")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<RendezVous> getAllRendezVous() {
        List<RendezVous> rendezVousList = new ArrayList<>();
        String sql = "SELECT * FROM Rendez_vous";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                rendezVousList.add(new RendezVous(
                        rs.getInt("RendV_ID"),
                        rs.getDate("Appoinment_Date"),
                        rs.getInt("Patient_ID"),
                        rs.getInt("Doctor_ID"),
                        rs.getTime("time")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendezVousList;
    }

    public boolean updateRendezVous(RendezVous rendezVous) {
        String sql = "UPDATE Rendez_vous SET Appoinment_Date = ?, Patient_ID = ?, Doctor_ID = ?, date = ?, time = ? WHERE RendV_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, rendezVous.getAppointmentDate());
            stmt.setInt(2, rendezVous.getPatientId());
            stmt.setInt(3, rendezVous.getDoctorId());
            stmt.setTime(5, rendezVous.getTime());
            stmt.setInt(6, rendezVous.getRendvId());

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteRendezVous(int id) {
        String sql = "DELETE FROM Rendez_vous WHERE RendV_ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

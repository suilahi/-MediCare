package com.medicare.web;

import com.medicare.Model.RendezVous;
import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RendezVousServlet")
public class RendezVousServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<RendezVous> rendezVousList = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String rendvIdStr = request.getParameter("rendvId");
            String patientIdStr = request.getParameter("patientId");
            String doctorIdStr = request.getParameter("doctorId");
            String dateStr = request.getParameter("date");
            String timeStr = request.getParameter("time");


            if (rendvIdStr == null || patientIdStr == null || doctorIdStr == null || dateStr == null || timeStr == null ||
                    rendvIdStr.isEmpty() || patientIdStr.isEmpty() || doctorIdStr.isEmpty() || dateStr.isEmpty() || timeStr.isEmpty()) {
                response.getWriter().write("Erreur: Un ou plusieurs paramètres sont manquants ou vides.");
                return;
            }

            int rendvId = Integer.parseInt(rendvIdStr);
            int patientId = Integer.parseInt(patientIdStr);
            int doctorId = Integer.parseInt(doctorIdStr);
            Date date = Date.valueOf(dateStr);
            Time time = Time.valueOf(timeStr);

            RendezVous rendezVous = new RendezVous(rendvId, date, patientId, doctorId, time);
            rendezVousList.add(rendezVous);

            response.getWriter().write("Rendez-vous ajouté avec succès");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de l'ajout du rendez-vous: " + e.getMessage());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        StringBuilder responseText = new StringBuilder("<h2>Liste des Rendez-vous</h2><ul>");
        for (RendezVous rv : rendezVousList) {
            responseText.append("<li>ID: ").append(rv.getRendvId())
                    .append(", Patient: ").append(rv.getPatientId())
                    .append(", Docteur: ").append(rv.getDoctorId())
                    .append(", Date: ").append(rv.getAppointmentDate())
                    .append(", Heure: ").append(rv.getTime())
                    .append("</li>");
        }
        responseText.append("</ul>");
        response.getWriter().write(responseText.toString());
    }
}

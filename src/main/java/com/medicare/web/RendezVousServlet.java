package com.medicare.web;

import com.medicare.Dao.patientDao;
import com.medicare.Model.RendezVous;
import com.medicare.Model.patient;

import java.io.IOException;
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
        String action=request.getServletPath();

        switch (action){
            case "/RendezVousServlet":
                insertPatient(request, response);
                break;
            default:
                System.out.println("Erreur RendezVousServlet");
                break;

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

    private void insertPatient(HttpServletRequest request, HttpServletResponse response)
              throws IOException {
        try {

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String telephone = request.getParameter("telephone");
            String motif= request.getParameter("motif");
            String dateStr = request.getParameter("date");
            String timeStr = request.getParameter("heure");

            if (username == null || email == null || telephone == null || dateStr == null || timeStr == null ||
                    username.isEmpty() || email.isEmpty() || telephone.isEmpty() || dateStr.isEmpty() || timeStr.isEmpty()) {
                response.getWriter().write("Erreur: Un ou plusieurs paramètres sont manquants ou vides.");
                return;
            }

            patient patient=new patient(username,email,telephone,motif);
            patientDao rendezVousDao=new patientDao();
            rendezVousDao.createRendezVous(patient);


            response.sendRedirect("/MediCare");
        } catch (Exception e) {
            response.getWriter().write("Erreur lors de l'ajout du rendez-vous: " + e.getMessage());
        }
    }

}


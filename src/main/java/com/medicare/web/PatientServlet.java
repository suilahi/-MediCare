package com.medicare.web;

import com.medicare.Dao.patientDao;
import com.medicare.Model.patient;
import com.medicare.Dao.ConnectionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/PatientServlet")
class PatientServlet extends HttpServlet {
    private patientDao patientDao;

    @Override
    public void init() throws ServletException {
        Connection connection = new ConnectionDao().connection();
        patientDao = new patientDao(connection);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("create".equals(action)) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String motif = request.getParameter("motif");

            patient newPatient = new patient(name, email, phone, motif);
            boolean isCreated = patientDao.createPatient(newPatient);

            if (isCreated) {
                response.sendRedirect("patientList");
            } else {
                response.getWriter().write("Error: Unable to create patient");
            }
        } else if ("update".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String motif = request.getParameter("motif");

            patient updatedPatient = new patient(id, name, email, phone, motif);
            boolean isUpdated = patientDao.updatePatient(updatedPatient);

            if (isUpdated) {
                response.sendRedirect("patientList");
            } else {
                response.getWriter().write("Error: Unable to update patient");
            }
        } else if ("delete".equals(action)) {

            int id = Integer.parseInt(request.getParameter("id"));
            boolean isDeleted = patientDao.deletePatient(id);

            if (isDeleted) {
                response.sendRedirect("patientList");
            } else {
                response.getWriter().write("Error: Unable to delete patient");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("getPatient".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            patient p = patientDao.getPatientById(id);
            if (p != null) {
                request.setAttribute("patient", p);
                request.getRequestDispatcher("/patient.jsp").forward(request, response);
            } else {
                response.getWriter().write("Error: Patient not found");
            }
        } else {
            List<patient> patients = patientDao.getAllPatients();
            request.setAttribute("patients", patients);
            request.getRequestDispatcher("/patientList.jsp").forward(request, response);
        }
    }
}

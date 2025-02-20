package com.medicare.Model;

import java.sql.Date;
import java.sql.Time;

public class RendezVous {
    private int rendvId;
    private Date appointmentDate;
    private int patientId;
    private int doctorId;
    private Date date;
    private Time time;


    public RendezVous(int rendvId, Date appointmentDate, int patientId, int doctorId, Date date, Time time) {
        this.rendvId = rendvId;
        this.appointmentDate = appointmentDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
    }

    public RendezVous( int rendvId, Date appointmentDate, int patientId, int doctorId, Date date) {
    }

    // Getters et Setters
    public int getRendvId() {
        return rendvId; }

    public void setRendvId(int rendvId) {
        this.rendvId = rendvId; }

    public Date getAppointmentDate() {
        return appointmentDate; }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate; }

    public int getPatientId() {
        return patientId; }

    public void setPatientId(int patientId) {
        this.patientId = patientId; }

    public int getDoctorId() {
        return doctorId; }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId; }

    public Date getDate() {
        return date; }

    public void setDate(Date date) {
        this.date = date; }

    public Time getTime() {
        return time; }

    public void setTime(Time time) {
        this.time = time; }
}

package com.medicare.Model;

import java.sql.Date;
import java.sql.Time;

public class RendezVous {
    private int rendvId;
    private Date Date;
    private int patientId;
    private int doctorId;
    private Time time;


    public RendezVous(int rendvId, Date Date, int patientId, int doctorId, Time time) {
        this.rendvId = rendvId;
        this.Date = Date;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.time = time;
    }

    public RendezVous( int rendvId, Date Date, int patientId, int doctorId) {
    }

    // Getters et Setters
    public int getRendvId() {
        return rendvId; }

    public void setRendvId(int rendvId) {
        this.rendvId = rendvId; }

    public Date getAppointmentDate() {
        return Date; }

    public void setAppointmentDate(Date appointmentDate) {
        this.Date = appointmentDate; }

    public int getPatientId() {
        return patientId; }

    public void setPatientId(int patientId) {
        this.patientId = patientId; }

    public int getDoctorId() {
        return doctorId; }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId; }

    public Time getTime() {
        return time; }

    public void setTime(Time time) {
        this.time = time; }
}

package iss.workshop.telemedicine_kat.model;

import com.google.gson.annotations.Expose;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Appointment {

    @Expose
    private int id;

    @Expose
    private Date appointmentDate;

    @Expose
    private String appointmentTime;

    @Expose
    private Doctor doctor;

    @Expose
    private Patient patient;

    @Expose
    private Prescription prescription;

    @Expose
    private MedicalCertificate mc;

    public Appointment(int id, Date appointmentDate, String appointmentTime, Doctor doctor, Patient patient, Prescription prescription, MedicalCertificate mc) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.doctor = doctor;
        this.patient = patient;
        this.prescription = prescription;
        this.mc = mc;
    }

    public int getId() {
        return id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public MedicalCertificate getMc() {
        return mc;
    }
}

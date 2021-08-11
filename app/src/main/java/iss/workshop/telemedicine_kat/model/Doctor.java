package iss.workshop.telemedicine_kat.model;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Doctor {
    @Expose
    private String doctorId;

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String gender;

    @Expose
    private String mobile;

    @Expose
    private String email;

    //private List<Appointment> appointmentListDoctor;


    public Doctor(String doctorId, String firstName, String lastName, String gender, String mobile, String email) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }
}

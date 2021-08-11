package iss.workshop.telemedicine_kat.Remote.Service;

import org.json.JSONArray;

import java.util.List;

import iss.workshop.telemedicine_kat.model.Appointment;
import iss.workshop.telemedicine_kat.model.MedicalCertificate;
import iss.workshop.telemedicine_kat.model.Patient;
import iss.workshop.telemedicine_kat.model.Prescription;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

//interface to specify paths available on target service
public interface MethodCallAPI {

    //we want to get back a list of Post objects with this call method (here, we name the method : getPosts()).
//    @GET("posts") //here we put the relative url where we get the list of posts from
//    Call<List<Post>> getPosts();


    //use List as call type since we are expecting to get back a json array
    //hardcode in patientId: 1
    @GET("api/list/1")
    Call<List<Appointment>> getAppointments();


    //if don't want to hardcode, use:
//    @GET("api/list/{patientId}")
//    Call<List<Appointment>> getAppointments(@Path("patientId") String id);


    //get patient name to display on top right of activity (done: 11/8/2021)
    //hardcode in patientId: 1
    @GET("api/patient/1")
    Call<Patient> getPatients();
}

package iss.workshop.telemedicine_kat.patient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import iss.workshop.telemedicine_kat.MyAdapter;
import iss.workshop.telemedicine_kat.R;
import iss.workshop.telemedicine_kat.Remote.APIUtils;
import iss.workshop.telemedicine_kat.Remote.Service.MethodCallAPI;
import iss.workshop.telemedicine_kat.model.Appointment;
import iss.workshop.telemedicine_kat.model.Patient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientConsultationHistoryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    List<Appointment> appointmentList;
    TextView patientFirstName;
    Patient patient;
    MethodCallAPI api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_consultation_history);

        //set up Back button for activity
        setupBackBtn();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //create retrofit object and define its base url that you declared in MethodCallAPI interface
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //create instance of MethodCallAPI interface so you can call methods that you need from the interface
        //alternative way : MethodCallAPI api = retrofit.create(MethodCallAPI.class);
        api = APIUtils.getMethodCallAPI();

        //get respective user First Name to display on top right of activity
        getUserName();

        //get appointment details for appointment date, prescription and mc
        getAppointmentDetails();
    }

    private void getUserName() {
        Call<Patient> call2 = api.getPatients();
        call2.enqueue(new Callback<Patient>() {
            @Override
            public void onResponse(Call<Patient> call, Response<Patient> response) {
                patient = response.body();

                patientFirstName = findViewById(R.id.tv_patientFirstName);
                if (patientFirstName != null) {
                    patientFirstName.setText(patient.getFirstName());
                }
            }

            @Override
            public void onFailure(Call<Patient> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void getAppointmentDetails() {
        //now that we have a retrofit object and API object, we can call our API method getAppointments().
        Call<List<Appointment>> call = api.getAppointments();

        //we call the method on a background thread using enqueue instead of execute to prevent blocking.
        call.enqueue(new Callback<List<Appointment>>() {

            @Override
            public void onResponse(Call<List<Appointment>> call, Response<List<Appointment>> response) {
                //if method call is successful...

                //check response (200-300 = successful; if not means something went wrong e.g. response 404)
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "error in response", Toast.LENGTH_LONG).show();
                    return;
                }

                //trying method 2 (11/8/2021)
                appointmentList = response.body();
                for (int i = 0; i < appointmentList.size(); i++) {
                    myAdapter = new MyAdapter(getApplicationContext(), appointmentList); //PatientConsultationHistoryActivity.this
                    recyclerView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }

            }
            @Override
            public void onFailure(Call<List<Appointment>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    private void setupBackBtn() {
        Button btn = findViewById(R.id.back);

        if (btn != null) {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    if (id == R.id.back) {
                        finish();
                    }
                }
            });
        }
    }
}
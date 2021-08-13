package iss.workshop.telemedicine_kat.patient;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;

import iss.workshop.telemedicine_kat.R;
import iss.workshop.telemedicine_kat.Remote.APIUtils;
import iss.workshop.telemedicine_kat.Remote.Service.MethodCallAPI;
import iss.workshop.telemedicine_kat.model.MedicalCertificate;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PatientMCActivity extends AppCompatActivity {

    MedicalCertificate mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mc);

        Intent intent = getIntent();
        String id = intent.getStringExtra("mcId");
        String dateFrom = intent.getStringExtra("mcDateFrom");
        String dateTo = intent.getStringExtra("mcDateTo");
        int duration = intent.getIntExtra("mcDuration", 0);

        TextView mcId = findViewById(R.id.mcId);
        TextView mcDateFrom = findViewById(R.id.dateFrom);
        TextView mcDateTo = findViewById(R.id.dateTo);
        TextView mcDuration = findViewById(R.id.duration);
        TableLayout table = findViewById(R.id.table);
        TextView noMC = findViewById(R.id.noMC);

        noMC.setVisibility(View.INVISIBLE);

        if (mcId != null)
            if (id != null)
                mcId.setText(id);
            else {
                table.setVisibility(View.INVISIBLE);
                noMC.setVisibility(View.VISIBLE);
            }

        if (mcDateFrom != null)
            if (dateFrom != null)
                mcDateFrom.setText(dateFrom);

        if (mcDateTo != null)
            if (dateTo != null)
                mcDateTo.setText(dateTo);

        if (mcDuration != null)
            if (duration != 0)
                mcDuration.setText(String.valueOf(duration) + " day(s)");

        //set up Back button for activity
        setupBackBtn();
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
package iss.workshop.telemedicine_kat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import iss.workshop.telemedicine_kat.patient.PatientConsultationHistoryActivity;
import iss.workshop.telemedicine_kat.patient.PatientMCActivity;
import iss.workshop.telemedicine_kat.patient.PatientPrescriptionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button consultationHistory_btn = findViewById(R.id.patient_view_consultationHistory);

        if (consultationHistory_btn != null) {
            consultationHistory_btn.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.patient_view_consultationHistory) {
            Intent intent = new Intent(this, PatientConsultationHistoryActivity.class);
            startActivity(intent);
        }
    }
}
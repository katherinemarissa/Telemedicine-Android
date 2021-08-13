package iss.workshop.telemedicine_kat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import iss.workshop.telemedicine_kat.model.Appointment;
import iss.workshop.telemedicine_kat.patient.PatientMCActivity;
import iss.workshop.telemedicine_kat.patient.PatientPrescriptionActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<Appointment> appointmentList;
    SimpleDateFormat sdf;

    public MyAdapter(Context mContext, List<Appointment> appointmentList) {
        this.mContext = mContext;
        this.appointmentList = appointmentList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //from (mContext) here
        v = layoutInflater.inflate(R.layout.activity_consultation_history_item, parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        sdf = new SimpleDateFormat("dd/MM/yyyy");
        String appointmentDate_Formatted = sdf.format(appointmentList.get(position).getAppointmentDate());
        holder.date.setText(appointmentDate_Formatted);


        holder.viewPrescription.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PatientPrescriptionActivity.class);
                intent.putExtra("prescriptionId", appointmentList.get(position).getPrescription().getPrescriptionId());
                intent.putExtra("prescriptionMedicine", appointmentList.get(position).getPrescription().getMedicine());
                intent.putExtra("prescriptionRemarks", appointmentList.get(position).getPrescription().getRemarks());
                v.getContext().startActivity(intent);
            }
        });

        holder.viewMc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PatientMCActivity.class);
                if (appointmentList.get(position).getMc() != null) {
                    intent.putExtra("mcId", appointmentList.get(position).getMc().getMcId());
                    String dateFrom_Formatted = sdf.format(appointmentList.get(position).getMc().getDateFrom());
                    intent.putExtra("mcDateFrom", dateFrom_Formatted);
                    String dateTo_Formatted = sdf.format(appointmentList.get(position).getMc().getDateTo());
                    intent.putExtra("mcDateTo", dateTo_Formatted);
                    intent.putExtra("mcDuration", appointmentList.get(position).getMc().getDuration());
                }
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {

        if (appointmentList != null) {
            return appointmentList.size();
        }
        else {
            return 0;
        }

    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        //instantiate widgets
        TextView date;
        Button viewPrescription;
        Button viewMc;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            //place respective widgets into viewholders
            date = itemView.findViewById(R.id.tv_consultationDate);
            viewPrescription = itemView.findViewById(R.id.btn_viewPrescription);
            viewMc = itemView.findViewById(R.id.btn_viewMc);

        }
    }

}

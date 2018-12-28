package android.dsi32.org.proosoft_project.views.tasks;

import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.commons.DateUtility;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;




public class EmployeeTaskAdapter extends RecyclerView.Adapter<DataModelEmployeeTask.MyViewHolder> {
    public ArrayList<DataModelEmployeeTask> dataset;
    public EmployeeTaskAdapter(ArrayList<DataModelEmployeeTask> dataModels ){
        this.dataset=dataModels;
    }

    @Override
    public DataModelEmployeeTask.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_task_for_employee_new,parent,false);
        return new DataModelEmployeeTask.MyViewHolder(view);
    }


    public void onBindViewHolder(@NonNull DataModelEmployeeTask.MyViewHolder holder, int position) {
        TextView textView=holder.textViewName;
        TextView textViewdate_fin=holder.textViewdate_fin;
        TextView textViewStart=holder.textViewdat_start;
        TextView textViewdate_deadline=holder.textViewdate_deadline;
        ImageView task_done_circle = holder.task_done_circle;
        TextView dateDeadlineTmp = holder.dateDeadline;
        String state = dataset.get(position).getState();
        Switch aSwitch = holder.aSwitch;
        //aSwitch.setEnabled(false);

        boolean isDone = dataset.get(position).getState().equals("done") ? true : false;
        if(isDone) {
            aSwitch.setChecked(true);
        }else{
            aSwitch.setChecked(false);
        }



        String taskEndDate=dataset.get(position).getDate_fin();
        String taskDeadline = dataset.get(position).getDate_deadline();
        //boolean isDone = dataset.get(position).getState().equals("done") ? true : false;
        if(!taskDeadline.isEmpty() && !isDone) {
            try {
                int remainingDays=0;
                     remainingDays = DateUtility.guessRemainingDays(taskDeadline);

                if(remainingDays <=3) {
                    /*holder.alert_echeance_icon.setVisibility(View.VISIBLE);
                    holder.alert_echeance_text.setVisibility(View.VISIBLE);*/
                    holder.alertt.setVisibility(View.VISIBLE);
                    if(remainingDays <0) {
                        holder.alertt.setVisibility(View.VISIBLE);
                            //   holder.alert_echeance_text.setText("deadline depassé");
                    }else if(remainingDays == 0) {
                        holder.alertt.setVisibility(View.VISIBLE);
                       // holder.alert_echeance_text.setText("deadline aujourdhui");
                    }else {
                        //holder.alert_echeance_text.setText(remainingDays+" jours restants");
                    }
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        textView.setText(dataset.get(position).getName());
        textViewdate_fin.setText(taskEndDate);
        dateDeadlineTmp.setText(dataset.get(position).getDate_deadline());

        // textViewStart.setText(dataset.get(position).getDate_start());

        textViewdate_fin.setText(dataset.get(position).getDate_fin());
        textViewdate_deadline.setText(dataset.get(position).getDate_deadline());
        //Simple


    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
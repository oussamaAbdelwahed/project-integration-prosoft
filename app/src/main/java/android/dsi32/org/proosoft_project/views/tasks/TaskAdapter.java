package android.dsi32.org.proosoft_project.views.tasks;

import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.buttonsclicklisteners.OnBtnChangeTaskStateClick;
import android.dsi32.org.proosoft_project.buttonsclicklisteners.OnBtnTaskAssignedToClick;
import android.dsi32.org.proosoft_project.commons.DateUtility;
import android.dsi32.org.proosoft_project.views.project.DataModel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import java.text.ParseException;
import java.util.ArrayList;
import static android.dsi32.org.proosoft_project.views.tasks.DataModelTask.*;
public class TaskAdapter extends RecyclerView.Adapter<DataModelTask.MyViewHolder> {
    public ArrayList<DataModelTask> dataset;
    public TaskAdapter(ArrayList<DataModelTask> dataModels ){
        this.dataset=dataModels;
    }

    @Override
    public DataModelTask.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_task_new,parent,false);
        return new DataModelTask.MyViewHolder(view);
    }


    public void onBindViewHolder(@NonNull DataModelTask.MyViewHolder holder, int position) {
        TextView textView=holder.textViewName;
        TextView textViewdate_fin=holder.textViewdate_fin;
        TextView textViewdate_deadline=holder.textViewdate_deadline;
        TextView textViewdate_start= holder.textViewdate_start;
        TextView textState = holder.textState;
        TextView textViewDeadline = holder.textViewdate_deadline;
        LinearLayout alert = holder.alert;
       ImageView task_done_circle = holder.task_done_circle;

        Switch aSwitch = holder.aSwitch;
        String state = dataset.get(position).getState();

        holder.button_assigned_to.setOnClickListener(new OnBtnTaskAssignedToClick(this.dataset.get(position).getAssignedToId()));
        holder.aSwitch.setOnClickListener(new OnBtnChangeTaskStateClick(dataset.get(position).getId()));
        if(state.equals("done")) {
            holder.alert.setVisibility(View.VISIBLE);
        }
        String taskStartDate=dataset.get(position).getDate_start();
        String taskEndDate=dataset.get(position).getDate_fin();
        String taskDeadline = dataset.get(position).getDate_deadline();
        boolean isDone = dataset.get(position).getState().equals("done") ? true : false;
        if(isDone) {
          aSwitch.setChecked(true);
        }

        if(!taskDeadline.isEmpty() && !isDone) {
            try {
                int remainingDays = 0;
               /* if (taskDeadline.length()>10){
                    remainingDays=  DateUtility.guessRemainingDaysSpecial(taskDeadline);
                }else {

                }*/
                remainingDays=  DateUtility.guessRemainingDays(taskDeadline);
                if(remainingDays <=3) {
/*                    holder.alert_echeance_icon.setVisibility(View.VISIBLE);*/
                    holder.alert.setVisibility(View.VISIBLE);
                    if(remainingDays <0) {
                      /*  holder.alert_echeance_text.setText("deadline depassé");*/
                    }else if(remainingDays == 0) {
                        holder.alert.setVisibility(View.VISIBLE);
                    }else {

                        holder.alert.setVisibility(View.VISIBLE);
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //Simple

        textView.setText(dataset.get(position).getName());
        textViewdate_start.setText(dataset.get(position).getDate_start());
        textViewdate_deadline.setText(dataset.get(position).getDate_deadline());
        textState.setText(state);



        textViewdate_fin.setText(taskEndDate);
        textViewdate_fin.setText(dataset.get(position).getDate_deadline());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

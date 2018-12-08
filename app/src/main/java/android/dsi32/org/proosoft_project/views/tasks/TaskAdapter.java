package android.dsi32.org.proosoft_project.views.tasks;

import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.commons.DateUtility;
import android.dsi32.org.proosoft_project.views.project.DataModel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_task,parent,false);
        return new DataModelTask.MyViewHolder(view);
    }


    public void onBindViewHolder(@NonNull DataModelTask.MyViewHolder holder, int position) {
        TextView textView=holder.textViewName;
        TextView textViewdate_fin=holder.textViewdate_fin;
        TextView textViewdate_deadline=holder.textViewdate_deadline;
        ImageView task_done_circle = holder.task_done_circle;
        String state = dataset.get(position).getState();
        if(state.equals("done")) {
            holder.task_done_circle.setVisibility(View.VISIBLE);
        }
        String taskEndDate=dataset.get(position).getDate_fin();
        String taskDeadline = dataset.get(position).getDate_deadline();
        boolean isDone = dataset.get(position).getState().equals("done") ? true : false;
        if(!taskDeadline.isEmpty() && !isDone) {
            try {
                int remainingDays = DateUtility.guessRemainingDays(taskDeadline);
                if(remainingDays <=3) {
                    holder.alert_echeance_icon.setVisibility(View.VISIBLE);
                    holder.alert_echeance_text.setVisibility(View.VISIBLE);
                    if(remainingDays <0) {
                        holder.alert_echeance_text.setText("deadline depassé");
                    }else if(remainingDays == 0) {
                        holder.alert_echeance_text.setText("deadline aujourdhui");
                    }else {
                        holder.alert_echeance_text.setText(remainingDays+" jours restants");
                    }
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //Simple

        textView.setText(dataset.get(position).getName());
        textViewdate_fin.setText(taskEndDate);
        textViewdate_fin.setText(dataset.get(position).getDate_deadline());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

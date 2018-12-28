package android.dsi32.org.proosoft_project.views.tasks;

import android.dsi32.org.proosoft_project.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

public class DataModelTask {
    private String name;
    private String date_start;
    private String date_fin ;
    private String date_deadline;
    private String username;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer assignedToId;
    private Integer id;

    public Integer getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(Integer assignedToId) {
        this.assignedToId = assignedToId;
    }



    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DataModelTask() {}

    public DataModelTask(String name,String date_start,String date_fin,String date_deadline,String username,Integer id) {
        this.id = id;
        this.name = name;
        this.date_start= date_start;
        this.date_fin = date_fin;
        this.date_deadline=date_deadline;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public String getDate_deadline() {
        return date_deadline;
    }

    public void setDate_deadline(String date_deadline) {
        this.date_deadline = date_deadline;
    }


    public String getDate_start() {
        return date_start;
    }

    public void setDate_start(String date_start) {
        this.date_start = date_start;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewdate_fin;
        TextView textViewdate_start;
        TextView textViewdate_deadline;
        TextView textState;
        ImageView task_done_circle;
        ImageView alert_echeance_icon;
        TextView alert_echeance_text;
        Button button_assigned_to;
        LinearLayout alert;
        Switch aSwitch;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.nametask);
            this.textViewdate_start=itemView.findViewById(R.id.date_start);
            this.textViewdate_fin=itemView.findViewById(R.id.date_end);
            this.textViewdate_deadline=itemView.findViewById(R.id.date_deadline);
            this.task_done_circle = itemView.findViewById(R.id.task_done_circle);
            this.alert_echeance_icon = itemView.findViewById(R.id.alert_echeance_icon);
            this.textState = itemView.findViewById(R.id.state);
          /*  this.alert_echeance_text = itemView.findViewById(R.id.alert_echeance_text);*/
            this.button_assigned_to = itemView.findViewById(R.id.button_assigned_to);
            this.alert = itemView.findViewById(R.id.alertt);
            aSwitch = itemView.findViewById(R.id.switch1);

        }

    }
}



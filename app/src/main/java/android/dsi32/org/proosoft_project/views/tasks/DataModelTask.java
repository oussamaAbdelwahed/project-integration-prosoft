package android.dsi32.org.proosoft_project.views.tasks;

import android.dsi32.org.proosoft_project.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DataModelTask {
    private String name;
    private String date_fin ;
    private String date_deadline;
    private String username;

    public DataModelTask() {}

    public DataModelTask(String name,String date_fin,String date_deadline,String username) {
        this.name = name;
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



    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewdate_fin;
        TextView textViewdate_deadline;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.nametask);
            this.textViewdate_fin=itemView.findViewById(R.id.date_end);
            this.textViewdate_deadline=itemView.findViewById(R.id.date_deadline);
        }

    }
}



package android.dsi32.org.proosoft_project.views.tasks;

import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.views.project.DataModel;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

        textView.setText(dataset.get(position).getName());
        textViewdate_fin.setText(dataset.get(position).getDate_fin());
        textViewdate_fin.setText(dataset.get(position).getDate_deadline());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

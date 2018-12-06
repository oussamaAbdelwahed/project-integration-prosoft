package android.dsi32.org.proosoft_project.views.project;


import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.buttonsclicklisteners.OnBtnProjectTasksClick;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static android.dsi32.org.proosoft_project.views.project.DataModel.*;

public class CustomAdapter extends RecyclerView.Adapter<DataModel.MyViewHolder> {
    public ArrayList<DataModel> dataset;
    public CustomAdapter(ArrayList<DataModel> dataModels ){
        this.dataset=dataModels;
    }

    @Override
    public DataModel.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Layout l = R.layout.ligne_project;
        //parent.setTag();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ligne_project,parent,false);
        return new DataModel.MyViewHolder(view);
    }



    public void onBindViewHolder(@NonNull DataModel.MyViewHolder holder, int position) {
       holder.button.setOnClickListener(new OnBtnProjectTasksClick(dataset.get(position).getId()));
        TextView textView=holder.textViewName;
        TextView managerView=holder.textViewManager;
        textView.setText(dataset.get(position).getName());
        managerView.setText(dataset.get(position).getManager());
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }
}

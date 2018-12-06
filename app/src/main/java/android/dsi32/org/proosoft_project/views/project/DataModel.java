package android.dsi32.org.proosoft_project.views.project;

import android.dsi32.org.proosoft_project.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataModel {
    private String name;
    private String manager;

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private  Integer id;
    public DataModel(Integer id,String name,String manager){
        this.id = id;
        this.name=name;
        this.manager=manager;
    }

    public String getName() {
        return this.name;
    }

    public String getManager() {
        return this.manager;
    }

    public DataModel() {}

   public static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView textViewName;
         TextView textViewManager;
         Button button;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.name);
            this.textViewManager=itemView.findViewById(R.id.manger);
            this.button = itemView.findViewById(R.id.button_project);
        }

       public TextView getTextViewName() {
           return textViewName;
       }

       public void setTextViewName(TextView textViewName) {
           this.textViewName = textViewName;
       }

       public TextView getTextViewManager() {
           return textViewManager;
       }

       public void setTextViewManager(TextView textViewManager) {
           this.textViewManager = textViewManager;
       }
   }
}




package android.dsi32.org.proosoft_project.views.project;

import android.dsi32.org.proosoft_project.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DataModel {
    private String name;
    private String manager ;
    public DataModel(String name,String manager){
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



        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.name);
            this.textViewManager=itemView.findViewById(R.id.manger);

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




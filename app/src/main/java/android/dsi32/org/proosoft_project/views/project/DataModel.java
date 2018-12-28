package android.dsi32.org.proosoft_project.views.project;

import android.dsi32.org.proosoft_project.R;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DataModel {
    private String name;
    private String manager;
    private String nbrTAsk;
    private  Integer id;
    private  String dateEnd;
    private String dateStart ;
    private  String deadLine;

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

    public String getNbrTAsk() {
        return nbrTAsk;
    }

    public void setNbrTAsk(String nbrTAsk) {
        this.nbrTAsk = nbrTAsk;
    }

    public DataModel(Integer id, String name, String nbrTAsk, String dateStart, String dateEnd){
        this.id = id;
        this.name=name;
        this.nbrTAsk = nbrTAsk;
        this.dateEnd =dateEnd;
        this.dateStart = dateStart;


    }

    public String getName() {
        return this.name;
    }

    public String getManager() {
        return this.manager;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public DataModel() {}

   public static class MyViewHolder extends RecyclerView.ViewHolder {
         TextView textViewName;
         TextView textViewdateStart;
         TextView textViewdateEnd;
         TextView textViewNbTask;
       AppCompatImageView button;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName=itemView.findViewById(R.id.name);
            this.textViewdateStart=itemView.findViewById(R.id.startdate);
            this.textViewdateEnd=itemView.findViewById(R.id.endDate);
            this.textViewNbTask=itemView.findViewById(R.id.nbTache);
            this.button = itemView.findViewById(R.id.button_project);
        }

       public TextView getTextViewName() {
           return textViewName;
       }

       public void setTextViewName(TextView textViewName) {
           this.textViewName = textViewName;
       }

   }
}




package android.dsi32.org.proosoft_project.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class ProjectParcelable implements Parcelable,Serializable{
    private Integer id;
    String date;
    private String startDate,name;
    private int taskNbr;


    public static final Parcelable.Creator<ProjectParcelable> CREATOR = new Parcelable.Creator<ProjectParcelable>() {
        @Override
        public ProjectParcelable createFromParcel(Parcel in) {
            return new ProjectParcelable(in);
        }

        @Override
        public ProjectParcelable[] newArray(int size) {
            return new ProjectParcelable[size];
        }
    };



    public ProjectParcelable() {}


    protected ProjectParcelable(Parcel in) {
        name = in.readString();
        date=in.readString();
        startDate = in.readString();
        taskNbr= in.readInt();
        id=in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(date);
        dest.writeString(startDate);
        dest.writeInt(taskNbr);
        dest.writeLong(id);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaskNbr() {
        return taskNbr;
    }

    public void setTaskNbr(int taskNbr) {
        this.taskNbr = taskNbr;
    }

    @Override
    public String toString() {
        return "ProjectParcelable{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", startDate='" + startDate + '\'' +
                ", name='" + name + '\'' +
                ", taskNbr=" + taskNbr +
                '}';
    }


}

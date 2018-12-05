package android.dsi32.org.proosoft_project.models;

import java.io.Serializable;

public class Project implements Serializable{
    private Integer id;
    private String endDate,startDate,name;
    private int taskNbr;

    public Project() { }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String date) {
        this.endDate = date;
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
        return "Project{" +
                "id=" + id +
                ", endDate='" + endDate + '\'' +
                ", startDate='" + startDate + '\'' +
                ", name='" + name + '\'' +
                ", taskNbr=" + taskNbr +
                '}';
    }
}

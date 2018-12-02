package android.dsi32.org.proosoft_project.models;

public class Porject {
    private Long id;
    private String date,startDate,name;
    private int taskNbr;

    public Porject() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}

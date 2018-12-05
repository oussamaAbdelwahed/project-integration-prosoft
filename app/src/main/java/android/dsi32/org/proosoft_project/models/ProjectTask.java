package android.dsi32.org.proosoft_project.models;

public class ProjectTask {
    private Integer id;
    private String name;
    private String dateStart;
    private String dateEnd;
    private String dateDeadline;

    private Project project;
    private User user;

    public ProjectTask() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getDateDeadline() {
        return dateDeadline;
    }

    public void setDateDeadline(String dateDeadline) {
        this.dateDeadline = dateDeadline;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                ", dateDeadline='" + dateDeadline + '\'' +
                ", project id=" + project.getId() + ",project name = "+project.getName()+
                ", user id "+user.getId()+" user name "+user.getName()+
                '}';
    }
}

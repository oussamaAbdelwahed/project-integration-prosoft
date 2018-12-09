package android.dsi32.org.proosoft_project.models;

public class User {
    private Integer id;
    private String name;
    private String email;
    private String tel;
    private String function;

    public User() {}

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

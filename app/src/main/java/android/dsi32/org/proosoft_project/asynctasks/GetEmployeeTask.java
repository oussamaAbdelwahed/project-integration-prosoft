package android.dsi32.org.proosoft_project.asynctasks;

import android.dsi32.org.proosoft_project.models.User;
import android.dsi32.org.proosoft_project.services.EmployeeService;
import android.os.AsyncTask;

import java.util.Map;

public class GetEmployeeTask extends AsyncTask<Integer,Integer,User> {

    private EmployeeService employeeService;

    public GetEmployeeTask(EmployeeService service) {
        this.employeeService = service;
    }

    @Override
    public void onPreExecute() {

    }

    @Override
    protected User doInBackground(Integer... integers) {
        Map<String ,Object> result = this.employeeService.getTaskEmployee(integers[0]);
        User user = new User();
        user.setId(Integer.valueOf(result.get("id").toString()));
        user.setName(String.valueOf(result.get("name")));
        user.setEmail(String.valueOf(result.get("email")));
        user.setTel(String.valueOf(result.get("mobile")));
        user.setFunction(String.valueOf(result.get("function")));
        return user;
    }
    @Override
    public void onPostExecute(User user) {

    }


}

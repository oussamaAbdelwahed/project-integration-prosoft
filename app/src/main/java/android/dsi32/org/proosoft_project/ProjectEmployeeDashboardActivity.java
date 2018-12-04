package android.dsi32.org.proosoft_project;

import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ProjectEmployeeDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_employee_dashboard);
        SharedPreferenceService s = new SharedPreferenceService(this);
        ProjectTaskService service = new ProjectTaskService(this,s);
        Thread t = new Thread(() -> {
           service.getEmployeeTasks();
        });
        t.start();
    }
}

package android.dsi32.org.proosoft_project;

import android.dsi32.org.proosoft_project.asynctasks.GetEmployeeTasksTask;
import android.dsi32.org.proosoft_project.models.ProjectTask;
import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.dsi32.org.proosoft_project.views.project.CustomAdapter;
import android.dsi32.org.proosoft_project.views.project.DataModel;
import android.dsi32.org.proosoft_project.views.tasks.DataModelTask;
import android.dsi32.org.proosoft_project.views.tasks.TaskAdapter;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutionException;

public class ProjectEmployeeDashboardActivity extends AppCompatActivity {
    ArrayList<DataModelTask> dataModels;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_employee_dashboard);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        this.recyclerView=findViewById(R.id.listtask);


        SharedPreferenceService s = new SharedPreferenceService(this);
        ProjectTaskService service = new ProjectTaskService(this,s);
        GetEmployeeTasksTask task = new GetEmployeeTasksTask(service);
        task.execute();
        List<ProjectTask> employeeTasks = null;
        try {
            if((employeeTasks=task.get())!=null) {
                dataModels=new ArrayList<>();
                for(int i=0;i<employeeTasks.size();i++)
                {
                    DataModelTask dm = new DataModelTask();
                    dm.setUsername(employeeTasks.get(i).getUser().getName());
                    dm.setName(employeeTasks.get(i).getName());
                    dm.setDate_deadline(employeeTasks.get(i).getDateDeadline());
                    dm.setDate_fin(employeeTasks.get(i).getDateEnd());
                    dataModels.add(dm);
                }

                this.recyclerView.setLayoutManager(layoutManager);
                adapter=new TaskAdapter(dataModels);
                this.recyclerView.setAdapter(adapter);

                ProgressBar spinner = findViewById(R.id.spinner1);
                spinner.setVisibility(View.INVISIBLE);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

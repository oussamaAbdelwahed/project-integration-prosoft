package android.dsi32.org.proosoft_project;

import android.content.Intent;
import android.dsi32.org.proosoft_project.asynctasks.GetEmployeeTasksTask;
import android.dsi32.org.proosoft_project.asynctasks.GetProjectTasksTask;
import android.dsi32.org.proosoft_project.models.ProjectTask;
import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.dsi32.org.proosoft_project.views.tasks.DataModelTask;
import android.dsi32.org.proosoft_project.views.tasks.TaskAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ProjectTasksActivity extends AppCompatActivity {

    private Integer projectId;
    ArrayList<DataModelTask> dataModels;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.logout_link:
                Intent intent = new Intent(this, LoginActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_tasks);
        this.getProjectIdFromIntent();
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        this.recyclerView=findViewById(R.id.listprojecttasks);

        SharedPreferenceService s = new SharedPreferenceService(this);
        ProjectTaskService service = new ProjectTaskService(this,s);
        GetProjectTasksTask task = new GetProjectTasksTask(service);
        task.execute(this.projectId);
        List<ProjectTask> employeeTasks = null;
        try {
            if((employeeTasks=task.get())!=null) {
                dataModels=new ArrayList<>();
                for(int i=0;i<employeeTasks.size();i++){
                    DataModelTask dm = new DataModelTask();
                    dm.setUsername(employeeTasks.get(i).getUser().getName());
                    dm.setName(employeeTasks.get(i).getName());
                    dm.setDate_deadline(employeeTasks.get(i).getDateDeadline());
                    dm.setDate_fin(employeeTasks.get(i).getDateEnd());
                    dm.setState(employeeTasks.get(i).getState());
                    dm.setAssignedToId(employeeTasks.get(i).getUser().getId());
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




    public  void getProjectIdFromIntent() {
        Intent intent = getIntent();
        this.projectId = intent.getIntExtra("projectId",0);
    }
}

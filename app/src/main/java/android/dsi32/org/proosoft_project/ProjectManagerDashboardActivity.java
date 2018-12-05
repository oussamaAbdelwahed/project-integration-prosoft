package android.dsi32.org.proosoft_project;

import android.dsi32.org.proosoft_project.models.Project;
import android.dsi32.org.proosoft_project.models.ProjectParcelable;
import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.dsi32.org.proosoft_project.views.project.CustomAdapter;
import android.dsi32.org.proosoft_project.views.project.DataModel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectManagerDashboardActivity extends AppCompatActivity {
    ArrayList<DataModel> dataModels;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_manager_dashboard);
        Bundle bundle = getIntent().getExtras();
        ArrayList<Project> ret =(ArrayList<Project>)getIntent().getSerializableExtra("listOfProjects");
        dataModels=new ArrayList<>();
        for(int i=0;i<ret.size();i++)
        {
            dataModels.add(new DataModel(ret.get(i).getName(), String.valueOf(ret.get(i).getTaskNbr())));
        }

        recyclerView=findViewById(R.id.list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new CustomAdapter(dataModels);
        recyclerView.setAdapter(adapter);

        /*SharedPreferenceService s = new SharedPreferenceService(this);
        ProjectTaskService service = new ProjectTaskService(this,s);


        Thread t = new Thread(() -> {
            service.getProjectTasks(2);
            //service.getEmployeeTasks();
        });
        t.start();*/
    }
}

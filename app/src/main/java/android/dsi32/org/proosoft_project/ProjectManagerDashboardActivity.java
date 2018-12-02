package android.dsi32.org.proosoft_project;

import android.dsi32.org.proosoft_project.models.ProjectParcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectManagerDashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_manager_dashboard);;
        Bundle bundle = getIntent().getExtras();
        ArrayList<ProjectParcelable> ret = bundle.getParcelableArrayList("listOfProjects");
    }
}

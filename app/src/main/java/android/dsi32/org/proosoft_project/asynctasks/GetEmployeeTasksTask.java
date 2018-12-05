package android.dsi32.org.proosoft_project.asynctasks;

import android.dsi32.org.proosoft_project.commons.BundleFiller;
import android.dsi32.org.proosoft_project.models.Project;
import android.dsi32.org.proosoft_project.models.ProjectTask;
import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.os.AsyncTask;

import java.util.List;
import java.util.Map;

public class GetEmployeeTasksTask extends AsyncTask<Void,Void,List> {
    private ProjectTaskService projectTaskService;

    public GetEmployeeTasksTask(ProjectTaskService service) {
        this.projectTaskService = service;
    }

    @Override
    public void onPreExecute() {}

    @Override
    protected List<ProjectTask> doInBackground(Void... voids) {
        List<Map<String,Object>> l = this.projectTaskService.getEmployeeTasks();
        return BundleFiller.getTasksListFromRaw(l);
    }

    @Override
    public void onPostExecute(List l) {

    }
}

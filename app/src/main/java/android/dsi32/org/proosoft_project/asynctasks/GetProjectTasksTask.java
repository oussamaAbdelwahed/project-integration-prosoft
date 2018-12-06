package android.dsi32.org.proosoft_project.asynctasks;

import android.dsi32.org.proosoft_project.commons.BundleFiller;
import android.dsi32.org.proosoft_project.models.ProjectTask;
import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.os.AsyncTask;

import java.util.List;
import java.util.Map;

public class GetProjectTasksTask extends AsyncTask<Integer,Void,List> {

    private ProjectTaskService projectTaskService;

    public GetProjectTasksTask(ProjectTaskService service) {
        this.projectTaskService = service;
    }

    @Override
    public void onPreExecute() {}


    @Override
    protected List doInBackground(Integer... integers) {
        List<Map<String,Object>> l = this.projectTaskService.getProjectTasks(integers[0]);
        return BundleFiller.getTasksListFromRaw(l);
    }


    @Override
    public void onPostExecute(List l) {

    }
}

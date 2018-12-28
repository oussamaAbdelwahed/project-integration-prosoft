package android.dsi32.org.proosoft_project.asynctasks;

import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.os.AsyncTask;

public class SetTaskStateTask extends AsyncTask<Integer, Void, Boolean> {

    private ProjectTaskService projectTaskService;
    private boolean updateToDone;

    public SetTaskStateTask(ProjectTaskService service, boolean updateToDone) {
        this.updateToDone = updateToDone;
        this.projectTaskService = service;
    }

    @Override
    protected Boolean doInBackground(Integer... integers) {
        boolean res = this.projectTaskService.updateTaskStatus(integers[0],this.updateToDone);
        return res;
    }
}

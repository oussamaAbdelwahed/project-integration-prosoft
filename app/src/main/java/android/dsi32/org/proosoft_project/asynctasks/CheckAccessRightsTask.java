package android.dsi32.org.proosoft_project.asynctasks;

import android.content.Context;
import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.services.AccessRightsService;
import android.os.AsyncTask;

public class CheckAccessRightsTask extends AsyncTask<String, Void, Boolean> {
    private AccessRightsService accessRightsService;
    private Context context;

    public CheckAccessRightsTask(AccessRightsService service) {
        this.accessRightsService  = service;
    }


    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Boolean doInBackground(String... strings) {
        boolean res = this.accessRightsService.checkAccessRights(Integer.valueOf(strings[0]),strings[1]);
        return res;
    }


    @Override
    protected void onPostExecute(Boolean b) {

    }

  public AccessRightsService getAccessRightsService() {
        return accessRightsService;
    }

    public void setAccessRightsService(AccessRightsService accessRightsService) {
        this.accessRightsService = accessRightsService;
    }
}

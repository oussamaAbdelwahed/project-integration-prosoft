package android.dsi32.org.proosoft_project.asynctasks;

import android.content.Context;
import android.dsi32.org.proosoft_project.services.AccessRightsService;
import android.os.AsyncTask;

import org.apache.xmlrpc.XmlRpcException;

import java.util.LinkedList;
import java.util.List;

public class RedirectDependingToRoleTask extends AsyncTask<String,Void,List>{

    private AccessRightsService accessRightsService;

    public RedirectDependingToRoleTask(AccessRightsService service) {
        this.accessRightsService = service;
    }

    @Override
    public void onPreExecute() { }

    @Override
    protected List doInBackground(String... strings) {
        try {
            return this.accessRightsService.isAProjectManager();
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return new LinkedList();
    }

    @Override
    public void onPostExecute(List res) { }
}

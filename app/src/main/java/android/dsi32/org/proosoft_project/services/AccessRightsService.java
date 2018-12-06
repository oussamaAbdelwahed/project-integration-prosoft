package android.dsi32.org.proosoft_project.services;


import android.content.Context;
import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.commons.ClientRpcUtilities;
import android.util.Log;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientException;

import java.util.HashMap;
import java.util.List;


import static java.util.Arrays.asList;


public class AccessRightsService {
    private SharedPreferenceService sharedPreferenceService;
    private XmlRpcClient xmlRpcClient;
    private Context context;

    public AccessRightsService() {}

    public AccessRightsService(Context context ,SharedPreferenceService sharedPreferenceService)  {
        this.context = context;
        ClientRpcUtilities util = new ClientRpcUtilities(this.context);
        this.xmlRpcClient = util.getConfiguredClient("/xmlrpc/2/object");
        this.sharedPreferenceService = sharedPreferenceService;
    }

    public XmlRpcClient getXmlRpcClient() {
        return xmlRpcClient;
    }

    public void setXmlRpcClient(XmlRpcClient xmlRpcClient) {
        this.xmlRpcClient = xmlRpcClient;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public SharedPreferenceService getSharedPreferenceService() {
        return sharedPreferenceService;
    }

    public void setSharedPreferenceService(SharedPreferenceService sharedPreferenceService) {
        this.sharedPreferenceService = sharedPreferenceService;
    }

    public boolean checkAccessRights(Integer id,String password)  {
        try {
            Object o = this.xmlRpcClient.execute("execute_kw", asList(
                    context.getString(R.string.odoo_db_name), id, password,
                    "project.project", "check_access_rights",
                    asList("write"),
                    new HashMap() {{ put("raise_exception", false); }}
            ));
            boolean res = (Boolean)o;
            Log.v("has-access-rights_to_login",String.valueOf(res));
            return res;

        } catch (XmlRpcException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List isAProjectManager() throws XmlRpcException{
        //this code is for checking if the connected user is a manager for at least un projet the we redirect him to view the list of the projects managed by him
            List l = asList((Object[])xmlRpcClient.execute("execute_kw", asList(
                    context.getString(R.string.odoo_db_name), this.sharedPreferenceService.getUserId(), this.sharedPreferenceService.getPassword(),
                    "project.project", "search_read",asList(asList(
                            asList("user_id", "=", this.sharedPreferenceService.getUserId()),
                            asList("active", "=", true))),
                    new HashMap() {{
                         put("fields", asList("name", "date_start","task_count","id"));
                         put("limit",10);
                    }}
            )));
            //"date"

            return l;
    }


}

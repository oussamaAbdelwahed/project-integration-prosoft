package android.dsi32.org.proosoft_project.services;

import android.content.Context;
import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.commons.ClientRpcUtilities;
import android.dsi32.org.proosoft_project.models.User;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class EmployeeService {
    private SharedPreferenceService sharedPreferenceService;
    private XmlRpcClient xmlRpcClient;
    private Context context;

    public EmployeeService(Context context, SharedPreferenceService sharedPreferenceService)  {
        this.context = context;
        ClientRpcUtilities util = new ClientRpcUtilities(this.context);
        this.xmlRpcClient = util.getConfiguredClient("/xmlrpc/2/object");
        this.sharedPreferenceService = sharedPreferenceService;
    }

    public Map<String,Object> getTaskEmployee(Integer userId){
        Map<String,Object> user = new HashMap<>();
        Integer id = this.sharedPreferenceService.getUserId();
        String password = this.sharedPreferenceService.getPassword();
        HashMap<String,List<String>> projectionObject = new HashMap<>();
        List<String> projectionFields = new LinkedList<>();
        projectionFields.add("id");
        projectionFields.add("name");
        projectionFields.add("email");
        projectionFields.add("mobile");
        projectionFields.add("function");
        projectionObject.put("fields",projectionFields);
        try {
            List result = asList((Object[])this.xmlRpcClient.execute("execute_kw", asList(
                   context.getString(R.string.odoo_db_name), id, password,
                   "res.users", "search_read",asList(asList(
                           asList("id", "=", userId)
                   )),projectionObject
           )));
            if(!result.isEmpty())
               return (HashMap<String, Object>)result.get(0);
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return user;
    }
}

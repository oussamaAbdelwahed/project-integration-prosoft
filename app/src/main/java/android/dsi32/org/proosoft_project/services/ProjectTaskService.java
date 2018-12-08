package android.dsi32.org.proosoft_project.services;

import android.content.Context;
import android.dsi32.org.proosoft_project.R;
import android.dsi32.org.proosoft_project.commons.ClientRpcUtilities;
import android.dsi32.org.proosoft_project.models.ProjectTask;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.asList;

public class ProjectTaskService {
    private SharedPreferenceService sharedPreferenceService;
    private XmlRpcClient xmlRpcClient;
    private Context context;

    public ProjectTaskService(Context context ,SharedPreferenceService sharedPreferenceService)  {
        this.context = context;
        ClientRpcUtilities util = new ClientRpcUtilities(this.context);
        this.xmlRpcClient = util.getConfiguredClient("/xmlrpc/2/object");
        this.sharedPreferenceService = sharedPreferenceService;
    }

   public List<Map<String,Object>> getEmployeeTasks() {
        Integer id = this.sharedPreferenceService.getUserId();
        String password = this.sharedPreferenceService.getPassword();
        List tasks=null;
       try {
           HashMap<String,List<String>> projectionObject = new HashMap<>();
           List<String> projectionFields = new LinkedList<>();
           projectionFields.add("id");
           projectionFields.add("name");
           projectionFields.add("project_id");
           projectionFields.add("date_start");
           projectionFields.add("date_end");
           projectionFields.add("date_deadline");
           projectionFields.add("user_id");
           projectionObject.put("fields",projectionFields);
           tasks = asList((Object[])this.xmlRpcClient.execute("execute_kw", asList(
                   context.getString(R.string.odoo_db_name), id, password,
                   "project.task", "search_read",asList(asList(
                            asList("user_id", "=", id)
                    )),projectionObject
           )));
       } catch (XmlRpcException e) {
           e.printStackTrace();
       }


       return tasks;
   }


   public List getProjectTasks(Integer projectId) {
       Integer id = this.sharedPreferenceService.getUserId();
       String password = this.sharedPreferenceService.getPassword();
       List tasks=null;
       try {
           HashMap<String,List<String>> projectionObject = new HashMap<>();
           List<String> projectionFields = new LinkedList<>();
           projectionFields.add("id");
           projectionFields.add("name");
           projectionFields.add("date_start");
           projectionFields.add("date_end");
           projectionFields.add("project_id");
           projectionFields.add("user_id");
           projectionFields.add("kanban_state");
           projectionFields.add("date_deadline");
           //
           projectionObject.put("fields",projectionFields);
           tasks = asList((Object[])this.xmlRpcClient.execute("execute_kw", asList(
                   context.getString(R.string.odoo_db_name), id, password,
                   "project.task", "search_read",asList(asList(
                           asList("project_id", "=", projectId),
                           asList("active", "=", true)
                   )),projectionObject
           )));
           /*System.out.println("tasks l ist size : *****"+tasks.size());
           Iterator it = tasks.iterator();
           while (it.hasNext()) {
               HashMap<String,Object> l = (HashMap<String, Object>) it.next();
               Set<String> s= l.keySet();
               Iterator<String> i = s.iterator();
               while (i.hasNext()) {
                   String tmp = (String) i.next();
                   if(tmp.equals("project_id")) {
                       if(!(l.get(tmp) instanceof  Boolean)) {
                           Object[] pro = (Object[]) l.get(tmp);
                           System.out.println("task-project-id = " + pro[0] + " task-project-name = " + pro[1]);
                       }
                   }else if(tmp.equals("user_id")) {
                       if(!(l.get(tmp) instanceof  Boolean)) {
                         Object[] user = (Object[]) l.get(tmp);
                          System.out.println("task-user-id = "+user[0]+" task-user-name = "+user[1]);
                       }
                   }else {
                       System.out.println(tmp + " " + String.valueOf(l.get(tmp)));
                   }
               }
           }*/
       } catch (XmlRpcException e) {
           e.printStackTrace();
       }

       return tasks;
   }


}

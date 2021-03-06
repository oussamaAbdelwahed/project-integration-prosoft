package android.dsi32.org.proosoft_project.commons;


import android.dsi32.org.proosoft_project.models.Project;
import android.dsi32.org.proosoft_project.models.ProjectParcelable;
import android.dsi32.org.proosoft_project.models.ProjectTask;
import android.dsi32.org.proosoft_project.models.User;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BundleFiller {
        public static Bundle fillBundleWithProjects(List<Map<String,Object>> content) {
        Iterator<Map<String,Object>> iterator = content.iterator();
        ArrayList<ProjectParcelable> l = new ArrayList<>();
        while(iterator.hasNext()) {
            Map<String, Object> project = iterator.next();
            ProjectParcelable pp = new ProjectParcelable();
            pp.setId((Integer) project.get("id"));
            pp.setName((String)project.get("name"));
            pp.setDate(String.valueOf(project.get("date")));
            pp.setStartDate(String.valueOf(project.get("date_start")));
            pp.setTaskNbr((Integer) project.get("task_count"));
            l.add(pp);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("listOfProjects",l);
        return bundle;
    }

    public static List<Project> getProjectsListFromRaw(List<Map<String,Object>> content) {
        List<Project> projects = new ArrayList<>();
        Iterator<Map<String,Object>> iterator = content.iterator();
        while(iterator.hasNext()) {
            Map<String, Object> project = iterator.next();
            Project p = new Project();
            p.setId((Integer) project.get("id"));
            p.setName((String)project.get("name"));
            p.setEndDate(String.valueOf(project.get("date")));
            p.setStartDate(String.valueOf(project.get("date_start")));
            p.setTaskNbr((Integer) project.get("task_count"));
            projects.add(p);
        }
        return projects;
    }

    public static  List<ProjectTask>  getTasksListFromRaw(List<Map<String,Object>> data) {
            if(data==null) {
                System.out.println("*****************DATA NULL***************");
            }
        List<ProjectTask> tasks = new LinkedList<>();
        Iterator<Map<String,Object>> iterator = data.iterator();
        while(iterator.hasNext()) {
            ProjectTask task = new ProjectTask();
            Map<String,Object> tmp = iterator.next();
            task.setId((Integer) tmp.get("id"));
            task.setName((String) tmp.get("name"));
            task.setDateStart(String.valueOf(tmp.get("date_start")));
            task.setState(String.valueOf(tmp.get("kanban_state")));
            task.setDateEnd(String.valueOf(tmp.get("date_end")));
            task.setDateDeadline(String.valueOf(tmp.get("date_deadline")));
            Project p = new Project();
            User u = new User();
            if(!(tmp.get("project_id") instanceof Boolean)) {
                Object[] project = (Object[]) tmp.get("project_id");
                p.setId((Integer) project[0]);
                p.setName((String) project[1]);
            }  if(!(tmp.get("user_id") instanceof Boolean)) {
                Object [] assignedTo = (Object[]) tmp.get("user_id");
                u.setId((Integer) assignedTo[0]);
                u.setName((String) assignedTo[1]);
            }
            task.setProject(p);
            task.setUser(u);
            tasks.add(task);
        }
        return tasks;
    }


}

package android.dsi32.org.proosoft_project.commons;


import android.dsi32.org.proosoft_project.models.Project;
import android.dsi32.org.proosoft_project.models.ProjectParcelable;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
            System.out.println(pp);
            l.add(pp);
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("listOfProjects",l);
       // bundle.putParcelableArrayList("listOfProjects",l);
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
}

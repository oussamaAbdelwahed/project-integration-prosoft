package android.dsi32.org.proosoft_project.commons;


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
        bundle.putParcelableArrayList("listOfProjects",l);
        return bundle;
    }
}

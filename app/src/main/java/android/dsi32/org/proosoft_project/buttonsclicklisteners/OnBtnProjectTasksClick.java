package android.dsi32.org.proosoft_project.buttonsclicklisteners;

import android.content.Intent;
import android.dsi32.org.proosoft_project.ProjectTasksActivity;
import android.dsi32.org.proosoft_project.models.Project;
import android.view.View;

public class OnBtnProjectTasksClick implements View.OnClickListener {
    private  Integer projectId;
    public OnBtnProjectTasksClick(Integer projectId) {
        this.projectId = projectId;
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(),ProjectTasksActivity.class);
        intent.putExtra("projectId",this.projectId);
        v.getContext().startActivity(intent);
    }
}

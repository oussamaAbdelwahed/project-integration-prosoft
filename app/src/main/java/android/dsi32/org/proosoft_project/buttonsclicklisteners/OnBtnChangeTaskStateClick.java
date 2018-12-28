package android.dsi32.org.proosoft_project.buttonsclicklisteners;
import android.dsi32.org.proosoft_project.asynctasks.SetTaskStateTask;
import android.dsi32.org.proosoft_project.services.ProjectTaskService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.view.View;
import android.widget.Switch;

public class OnBtnChangeTaskStateClick implements View.OnClickListener{
     private Integer taskId;

     public OnBtnChangeTaskStateClick(Integer taskId) {
         this.taskId = taskId;
     }

     public Integer getTaskId() {
        return taskId;
    }

     public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

      public OnBtnChangeTaskStateClick() {}

    @Override
    public void onClick(View v) {
        SharedPreferenceService sharedPreferenceService = new SharedPreferenceService(v.getContext());
        ProjectTaskService projectTaskService = new ProjectTaskService(v.getContext(),sharedPreferenceService);
        boolean isChecked = ((Switch)v).isChecked();
        SetTaskStateTask task = new SetTaskStateTask(projectTaskService,isChecked);
        task.execute(this.taskId);
    }
}

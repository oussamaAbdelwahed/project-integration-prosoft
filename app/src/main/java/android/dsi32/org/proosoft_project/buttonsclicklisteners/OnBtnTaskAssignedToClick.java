package android.dsi32.org.proosoft_project.buttonsclicklisteners;

import android.content.DialogInterface;
import android.dsi32.org.proosoft_project.asynctasks.GetEmployeeTask;
import android.dsi32.org.proosoft_project.models.User;
import android.dsi32.org.proosoft_project.services.EmployeeService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.support.v7.app.AlertDialog;
import android.view.View;

import java.util.concurrent.ExecutionException;

public class OnBtnTaskAssignedToClick implements View.OnClickListener {
    private Integer userId;


    public OnBtnTaskAssignedToClick() {}

    public OnBtnTaskAssignedToClick(Integer userId ) {
        this();
        this.userId = userId;

    }


    @Override
    public void onClick(View v) {
        SharedPreferenceService sharedPreferenceService = new SharedPreferenceService(v.getContext());
        EmployeeService employeeService = new EmployeeService(v.getContext(),sharedPreferenceService);
        GetEmployeeTask getEmployeeTask = new GetEmployeeTask(employeeService);

        getEmployeeTask.execute(this.userId);

        try {
            User u= null;
            if((u=getEmployeeTask.get())!=null) {
                AlertDialog.Builder ad;
                ad = new AlertDialog.Builder(v.getContext());
                ad.setTitle("Informations Employee");
                ad.setMessage("nom complet : "+u.getName()+"\n\nemail : "+u.getEmail()+"\n\ntel : "+u.getTel()+"\n\nfonction : "+u.getFunction()+"\n\n");

                ad.setIcon(android.R.drawable.btn_plus);
                ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog a=ad.create();
                a.show();
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}

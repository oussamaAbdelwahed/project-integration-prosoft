package android.dsi32.org.proosoft_project.auth;

import android.content.Context;
import android.content.Intent;
import android.dsi32.org.proosoft_project.ProjectEmployeeDashboardActivity;
import android.dsi32.org.proosoft_project.ProjectManagerDashboardActivity;
import android.dsi32.org.proosoft_project.asynctasks.CheckAccessRightsTask;
import android.dsi32.org.proosoft_project.asynctasks.RedirectDependingToRoleTask;
import android.dsi32.org.proosoft_project.services.AccessRightsService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.os.AsyncTask;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Authentication extends AsyncTask<String,Void,Integer>{
    private static final String ODDOO_SERVER_URL="http://192.168.1.8:8069";
    private static final String ODOO_DB_NAME="db_test_java_rpc";
    private ProgressBar loadingSpinner;
    public TextView result;
    private Context context;
    public TextView username,password;
    public FrameLayout btnSubmit;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Authentication(ProgressBar loadingSpinner) {
        this.loadingSpinner = loadingSpinner;
    }

    @Override
    protected  void onPreExecute() {
        this.loadingSpinner.setVisibility(View.VISIBLE);
        username.setEnabled(false);
        password.setEnabled(false);
        btnSubmit.setEnabled(false);
    }

    @Override
    protected Integer doInBackground(String... strings) {
        XmlRpcClient client = new XmlRpcClient();
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setEnabledForExtensions(true);
        int uid=-1;
        try {
            config.setServerURL(new URL(ODDOO_SERVER_URL + "/xmlrpc/2/common"));
            client.setConfig(config);
            Object[] params = new Object[]{ODOO_DB_NAME, strings[0], strings[1]}; // Ok & simple
            Object ret = client.execute("login", params);
            if (ret instanceof Integer) {
                uid = ((Integer) ret).intValue();
            }
        }catch (XmlRpcException | MalformedURLException e) {
            e.printStackTrace();
        }
        return uid;
    }

    @Override
    protected void onPostExecute(Integer res) {

        if (res <= 0) {
            this.result.setText("login fail");
            this.loadingSpinner.setVisibility(View.INVISIBLE);
            username.setEnabled(true);
            password.setEnabled(true);
            btnSubmit.setEnabled(true);
        } else {
            SharedPreferenceService sharedPreferenceService = new SharedPreferenceService(this.context);
            AccessRightsService accessRightsService = new AccessRightsService(this.context, sharedPreferenceService);
            CheckAccessRightsTask task = new CheckAccessRightsTask(accessRightsService);
            task.execute(String.valueOf(res),this.password.getText().toString());
            try {
                if(task.get()==true) {
                    sharedPreferenceService.savePassword(this.password.getText().toString());
                    sharedPreferenceService.saveUserId(res);
                    this.result.setText("login success");
                    RedirectDependingToRoleTask redirectDependingToRoleTask = new RedirectDependingToRoleTask(accessRightsService);

                    redirectDependingToRoleTask.execute();
                    List l =null;
                    if((l=redirectDependingToRoleTask.get())!=null) {
                        if(l.size() >0) {
                            Intent intent = new Intent(this.context, ProjectManagerDashboardActivity.class);
                            this.context.startActivity(intent);
                        }else{
                            Intent intent = new Intent(this.context, ProjectEmployeeDashboardActivity.class);
                            this.context.startActivity(intent);
                        }
                    }
                }else{
                    this.result.setText("login fail");
                }
            } catch (ExecutionException | InterruptedException e) {
                e.printStackTrace();
            }
            username.setEnabled(true);
            password.setEnabled(true);
            btnSubmit.setEnabled(true);
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.loadingSpinner.setVisibility(View.INVISIBLE);
            super.onPostExecute(res);
        }
    }

}

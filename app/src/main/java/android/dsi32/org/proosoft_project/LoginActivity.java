package android.dsi32.org.proosoft_project;

import android.app.Activity;
import android.dsi32.org.proosoft_project.auth.Authentication;
import android.dsi32.org.proosoft_project.services.AccessRightsService;
import android.dsi32.org.proosoft_project.services.SharedPreferenceService;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.net.MalformedURLException;

public class LoginActivity extends AppCompatActivity {
    EditText username,password;
    TextView result;
    FrameLayout logIn;
    ProgressBar progressBar;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username = findViewById(R.id.mail);
        password = findViewById(R.id.pass);
        logIn = findViewById(R.id.log);
        progressBar = findViewById(R.id.spinner);
        result = findViewById(R.id.mess);


        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Authentication auth = new Authentication(progressBar);
                auth.setContext(LoginActivity.this);
                auth.username=username;
                auth.password  = password;
                auth.btnSubmit = logIn;
                auth.result = LoginActivity.this.result;
                auth.execute(username.getText().toString(),password.getText().toString());
                Log.v("response-here","the response value");
            }
        });


    }
}

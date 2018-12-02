package android.dsi32.org.proosoft_project.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceService {
    public  static final String PASSWORD_KEY="password";
    public static final String USER_ID_KEY="user_id";
    private Context context;
    private  SharedPreferences sharedPreferences;

    public SharedPreferenceService() {}
    public SharedPreferenceService(Context context) {
        this();
        this.context = context;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void savePassword(String password) {
        SharedPreferences.Editor editor = this.sharedPreferences.edit();
        editor.putString(PASSWORD_KEY,password);
        editor.commit();
    }

    public String getPassword() {
          return this.sharedPreferences.getString(PASSWORD_KEY,null);
    }

    public void saveUserId(Integer userId) {
        SharedPreferences.Editor editor= this.sharedPreferences.edit();
        editor.putInt(USER_ID_KEY, userId);
        editor.commit();
    }

    public Integer getUserId() {
        return this.sharedPreferences.getInt(USER_ID_KEY,-1);
    }
}

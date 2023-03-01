package mo.ed.course.two.amit.day.one.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SharedPrefs {
    private final Context context_;
    public static final String PREFS_Logger = "LoggerFile";
    int PRIVATE_MODE = 0;
    public static SharedPreferences pref;
    public static SharedPreferences.Editor editor;

    public SharedPrefs(Context context) {
        this.context_ = context;
        pref = context_.getSharedPreferences(PREFS_Logger, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setSignInInfo(String userName, String email) {
        editor.putString(Constants.KEY_USERNAME, userName);
        editor.putString(Constants.KEY_EMAIL, email);
        editor.commit();
    }

    public HashMap<String, String> getSessionInfo(){
        HashMap<String, String> userInfo= new HashMap<>();
        userInfo.put(Constants.KEY_USERNAME, pref.getString(Constants.KEY_USERNAME, null));
        userInfo.put(Constants.KEY_EMAIL, pref.getString(Constants.KEY_EMAIL, null));
        return userInfo;
    }
}
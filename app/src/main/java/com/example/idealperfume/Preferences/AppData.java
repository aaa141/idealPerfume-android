package com.example.idealperfume.Preferences;

import android.content.Context;

public class AppData extends IPreference{
    private static AppData mInstance;

    private final String PREF_LOGIN_ID = "loginId";
    private final String PREF_LOGIN = "login";


    public static synchronized AppData getInstance(Context context) {
        if (mInstance == null)
            //synchronized (AppData.class) {
                mInstance = new AppData(context);
            //}

        return mInstance;
    }

    public AppData(Context context) {
        super(context);
        mContext = context;
        mSharedPreferences = mContext.getSharedPreferences("IdealPref", Context.MODE_PRIVATE);
    }

    public void setPREF_LOGIN_ID(String string) {
        putString(PREF_LOGIN_ID, string);
    }
    public String getPREF_LOGIN_ID() {
        return getString(PREF_LOGIN_ID);
    }

    public void setPREF_LOGIN(String string) {
        putString(PREF_LOGIN, string);
    }
    public String getPREF_LOGIN() {
        return getString(PREF_LOGIN);
    }


}

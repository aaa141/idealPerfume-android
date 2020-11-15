package com.example.idealperfume.Preferences;

import android.content.Context;
import android.content.SharedPreferences;

public class IPreference {
    Context mContext;
    private static IPreference sInstance;
    protected SharedPreferences mSharedPreferences;

    protected IPreference(Context appContext) {
        mContext = appContext;
    }

//    public static synchronized IPreference getInstance(Context context) {
//        if (sInstance == null) {
//            sInstance = new IPreference(context);
//            /*throw new IllegalStateException(IPreference.class.getSimpleName() +
//                    " is not initialized, call initializeInstance(..) method first.");*/
//        }
//        return sInstance;
//    }


    public int getInt(String key) {
        return mSharedPreferences.getInt(key, 0);
    }
    public int getInt(String key, int value) {
        return mSharedPreferences.getInt(key, value);
    }
    public float getFloat(String key) {
        return mSharedPreferences.getFloat(key, 0f);
    }
    public boolean getBoolean(String key) {
        return mSharedPreferences.getBoolean(key, false);
    }


    /*****/
    public void putInt(String key, int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void putString(String key, String value) {

        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void putFloat(String key, float value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }
    public void putBoolean(String key, boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /*****/
    public String getString(String key) {
        return mSharedPreferences.getString(key, "");
    }


    //
    public void clear() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}

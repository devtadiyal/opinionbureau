package com.logzero.opinionbureau.utility;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class Preference {

    private static Preference mInstance = null;
    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static String SharedPreferenceKey = "Ingradient"   ;

    private Preference() {
    }

    public static Preference getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Preference();
        }
        if (mPreferences == null) {
            mPreferences = context.getApplicationContext().getSharedPreferences(SharedPreferenceKey, Context.MODE_PRIVATE);
            mEditor = mPreferences.edit();
            mEditor.commit();
        }
        return mInstance;
    }

    public void saveInPreference(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }


    public String getFromPreference(String key) {
        return mPreferences.getString(key, "");
    }

    }
    //  HOW TO USE
//  Preference.getInstance(this).saveInPreference("dev","DEVENDRA");
//                Preference.getInstance(this).getFromPreference("dev");
//                System.out.println( "DEV "+Preference.getInstance(this).getFromPreference("dev"));
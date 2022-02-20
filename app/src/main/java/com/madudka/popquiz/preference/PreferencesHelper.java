package com.madudka.popquiz.preference;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    public static final String SAVE = "SAVE";
    private static final String LEVEL = "LEVEL";

    public static SharedPreferences getCustomPreferences(Context context, String name){
        return context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static int getLevel(SharedPreferences sharedPreferences){
        return sharedPreferences.getInt(LEVEL, 1);
    }

    public static void setLevel(SharedPreferences sharedPreferences, int numLevel){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(LEVEL, numLevel);
        editor.apply();
    }
}

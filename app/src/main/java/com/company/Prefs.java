package com.company;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class Prefs {

    private final SharedPreferences preferences;

    public Prefs(Context context) {
        preferences = context.getSharedPreferences("settings", Context.MODE_PRIVATE);
    }

    public void saveBoardState(){
        preferences.edit().putBoolean("isBoardShown", true).apply();
    }

    public boolean isBoardShown(){
        return preferences.getBoolean("isBoardShown", false);
    }

    public void saveImageUri(String uriString) {
        preferences.edit().putString("profileImage", uriString).apply();
        preferences.edit().putBoolean("isProfileImageChanged", true).apply();
    }

    public String getImageUri(){
        return preferences.getString("profileImage", null );
    }

    public void saveProfileEditText(String etText){
        preferences.edit().putString("profileET", etText).apply();
    }

    public String getProfileEditText(){
        return preferences.getString("profileET", "");
    }

    public void prefsCash(){
        @SuppressLint("CommitPrefEdits") SharedPreferences.Editor editor = preferences.edit();
        editor.remove("profileET").apply();
        editor.remove("profileImage").apply();
        editor.clear().apply();
    }
    }
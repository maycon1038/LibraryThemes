package com.msm.themes;

import static com.msm.themes.ThemeUtil.getModeNightFromPreferences;
import static com.msm.themes.ThemeUtil.getThemeFromPreferences;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SecurityBaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeUtil.getThemeId(getThemeFromPreferences(this)));

//Secure
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
   //https://developer.android.com/guide/topics/ui/look-and-feel/darktheme#altera%C3%A7%C3%B5es_de_configura%C3%A7%C3%A3o
        if(getModeNightFromPreferences(this)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }


}

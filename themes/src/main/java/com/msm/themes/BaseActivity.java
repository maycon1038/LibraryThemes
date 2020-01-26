package com.msm.themes;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import static com.msm.themes.ThemeUtil.getModeNightFromPreferences;
import static com.msm.themes.ThemeUtil.getThemeFromPreferences;

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeUtil.getThemeId(getThemeFromPreferences(this)));
   //https://developer.android.com/guide/topics/ui/look-and-feel/darktheme#altera%C3%A7%C3%B5es_de_configura%C3%A7%C3%A3o
        if(getModeNightFromPreferences(this)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }


}

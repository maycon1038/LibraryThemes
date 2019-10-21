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
      //  AppCompatDelegate.setDefaultNightMode(getModeNightFromPreferences(this));
        if(getModeNightFromPreferences(this)){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }


}

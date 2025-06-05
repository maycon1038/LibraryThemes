package com.msm.themes;

import android.app.UiModeManager;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;

import static com.msm.themes.ThemeUtil.getModeNightFromPreferences;
import static com.msm.themes.ThemeUtil.getThemeFromPreferences;

public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(ThemeUtil.getThemeId(getThemeFromPreferences(this)));
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

   //https://developer.android.com/guide/topics/ui/look-and-feel/darktheme#altera%C3%A7%C3%B5es_de_configura%C3%A7%C3%A3o
/*        if(getModeNightFromPreferences(this)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }*/
      /*  // Primeiro verifica se deve seguir o sistema
        int nightMode = AppCompatDelegate.getDefaultNightMode();

        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            // Se já estiver no modo escuro, muda para claro
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else if (nightMode == AppCompatDelegate.MODE_NIGHT_NO) {
            // Se estiver no modo claro, muda para seguir o sistema
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
        } else {
            // Se estiver no modo automático, força o modo escuro
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        if(getModeNightFromPreferences(this)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }*/



        // No onCreate() da sua Activity principal ou Application:
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);

        // Configuração do tema escuro/claro
        setupThemeListener();

    }


    private void setupThemeListener() {
        // Usando ComponentCallbacks2 em vez de ConfigurationListener
        getApplication().registerComponentCallbacks(new ComponentCallbacks2() {
            @Override
            public void onConfigurationChanged(@NonNull Configuration newConfig) {
                int currentNightMode = newConfig.uiMode & Configuration.UI_MODE_NIGHT_MASK;
                updateTheme(currentNightMode);
            }

            @Override
            public void onLowMemory() {
                // Não implementado
            }

            @Override
            public void onTrimMemory(int level) {
                // Não implementado
            }
        });
    }

    private void updateTheme(int nightMode) {
        int newMode = (nightMode == Configuration.UI_MODE_NIGHT_YES)
                ? AppCompatDelegate.MODE_NIGHT_YES
                : AppCompatDelegate.MODE_NIGHT_NO;

        if (AppCompatDelegate.getDefaultNightMode() != newMode) {
            AppCompatDelegate.setDefaultNightMode(newMode);
            recreate();
        }
    }

    @Override
    protected void onDestroy() {
        // Não é necessário desregistrar explicitamente no Android moderno
        super.onDestroy();
    }

}

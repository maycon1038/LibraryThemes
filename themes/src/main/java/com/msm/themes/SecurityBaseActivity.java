package com.msm.themes;

import static com.msm.themes.ThemeUtil.getThemeFromPreferences;

import android.app.UiModeManager;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.WindowCompat;

public abstract class SecurityBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        // Configuração de tema
        setTheme(ThemeUtil.getThemeId(getThemeFromPreferences(this)));

        // Configuração de segurança
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
        );

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
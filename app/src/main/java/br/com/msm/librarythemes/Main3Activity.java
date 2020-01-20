package br.com.msm.librarythemes;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.msm.themes.BaseActivity;
import com.msm.themes.ThemeUtil;

import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Main3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtil.setMyTheme(this, ThemeUtil.THEME_GREEN_DARK);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Main3Activity.this, ConfigActivity.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

}

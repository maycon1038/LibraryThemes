package br.com.msm.librarythemes;

import android.content.Intent;
import android.os.Bundle;

import com.msm.themes.BaseActivity;
import com.msm.themes.SecurityBaseActivity;
import com.msm.themes.ThemeUtil;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import static com.msm.themes.ThemeUtil.getModeNightFromPreferences;
public class Main3Activity extends BaseActivity implements  ActionMode.Callback {

    ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemeUtil.setMyTheme(this, ThemeUtil.THEME_GREEN_DARK);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

     /*   // Armazena os paddings originais da Toolbar
        final int toolbarInitialPaddingLeft = toolbar.getPaddingLeft();
        final int toolbarInitialPaddingTop = toolbar.getPaddingTop();
        final int toolbarInitialPaddingRight = toolbar.getPaddingRight();
        final int toolbarInitialPaddingBottom = toolbar.getPaddingBottom();

        ViewCompat.setOnApplyWindowInsetsListener(toolbar, (v, windowInsets) -> {
            Insets insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars());

            v.setPadding(
                    toolbarInitialPaddingLeft,
                    toolbarInitialPaddingTop + insets.top, // Adiciona o inset da status bar ao padding original do topo
                    toolbarInitialPaddingRight,
                    toolbarInitialPaddingBottom
            );
            return WindowInsetsCompat.CONSUMED; // Ou windowInsets
        });*/
        startActivity(new Intent(Main3Activity.this, ConfigActivity.class));
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        if(getModeNightFromPreferences(this)){
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.menu_delete_list, menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}

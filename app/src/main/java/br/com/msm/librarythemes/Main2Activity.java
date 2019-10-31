package br.com.msm.librarythemes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.msm.themes.ThemeUtil;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import static com.msm.themes.ThemeUtil.getModeNightFromPreferences;

public class Main2Activity extends AppCompatActivity {
	private boolean thema;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	 ThemeUtil.setMyTheme(this, ThemeUtil.THEME_GREEN_DARK);
		thema = getModeNightFromPreferences(Main2Activity.this);
		ThemeUtil.setMode(this, thema);
		setContentView(R.layout.activity_main2);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		FloatingActionButton fab = findViewById(R.id.fab);
		fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
						.setAction("Action", null).show();
			}
		});



		findViewById(R.id.btn_themaModo).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ThemeUtil.setMode(Main2Activity.this, !getModeNightFromPreferences(Main2Activity.this));
				recreate();
			}
		});


	}





	@Override
	protected void onResume() {
		super.onResume();
		if (thema != getModeNightFromPreferences(this)) {
			ThemeUtil.setMode(this, getModeNightFromPreferences(this));
			recreate();
		}


	}
}

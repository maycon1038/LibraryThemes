package br.com.msm.librarythemes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.msm.themes.ThemeUtil;

import static com.msm.themes.ThemeUtil.getModeNightFromPreferences;

public class MainActivity extends AppCompatActivity {

	private boolean thema;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ThemeUtil.setMyTheme(this, ThemeUtil.THEME_GREEN);
		thema = getModeNightFromPreferences(MainActivity.this);
		ThemeUtil.setMode(this, thema);
		setContentView(R.layout.activity_main);
		findViewById(R.id.btn_themaModo).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				ThemeUtil.setMode(MainActivity.this, !getModeNightFromPreferences(MainActivity.this));
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
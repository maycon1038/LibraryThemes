package br.com.msm.librarythemes;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.msm.themes.BaseActivity;
import com.msm.themes.CheckVersion;
import com.msm.themes.ThemeUtil;
import com.msm.themes.interfaces.CheckVersionApp;



public class ConfigActivity extends BaseActivity implements CheckVersionApp {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
			@SuppressLint("WrongConstant")
			@Override
			public void onClick(View v) {
				int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
				switch (currentNightMode) {
					case Configuration.UI_MODE_NIGHT_NO:
						ThemeUtil.setMode(ConfigActivity.this, true);
						recreate();
						break;
					case Configuration.UI_MODE_NIGHT_YES:
						ThemeUtil.setMode(ConfigActivity.this, false);
						recreate();
						break;
				}
			}
		});



		PackageInfo pInfo = null;
		try {
			pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);

			CheckVersion cv = new CheckVersion(this, pInfo);
			cv.getVersionPlayStore(this);
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}

	}



	@Override
	public void newVersionApp(String versionPlayStory, String dateUpdate, String news, String erro) {


		Log.d("newVersionApp",versionPlayStory +
				"\n" + dateUpdate +
				"\n" + news +
				"\n" + erro
		);
	}
}

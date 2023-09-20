package br.com.msm.librarythemes;

import static com.msm.themes.util.Util.checkInternet;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.material.dialog.MaterialDialogs;
import com.msm.themes.CheckVersion;
import com.msm.themes.SecurityBaseActivity;
import com.msm.themes.ThemeUtil;
import com.msm.themes.interfaces.CheckVersionApp;
import com.msm.themes.interfaces.iTranslation;
import com.msm.themes.util.Tradutor;
import com.msm.themes.util.themePreferencia;


public class ConfigActivity extends SecurityBaseActivity implements CheckVersionApp {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

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

		themePreferencia.setProvider(this,"teste");



		PackageInfo pInfo = null;
		try {
			pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);

			CheckVersion cv = new CheckVersion(this, pInfo);
			cv.getVersionPlayStore(this);
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}


	  new Tradutor(this,"The translated text, in the target language you configured, is passed to the success listener." ).setCallback(new iTranslation() {
			@Override
			public void textTranslation(String text) {
				Toast.makeText(ConfigActivity.this, text, Toast.LENGTH_SHORT).show();
			}
		});

	}



	@Override
	public void newVersionApp(String versionPlayStory, String dateUpdate, String news, String erro) {


		Log.d("newVersionApp",versionPlayStory +
				"\n" + dateUpdate +
				"\n" + news +
				"\n" + erro
		);
	}

	@Override
	protected void onResume() {
		super.onResume();
		checkInternet(this);
	}
}

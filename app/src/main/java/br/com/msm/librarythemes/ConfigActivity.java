package br.com.msm.librarythemes;

import static com.msm.themes.util.Util.checkInternet;

import android.annotation.SuppressLint;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.msm.themes.BaseActivity;
import com.msm.themes.CheckVersion;
import com.msm.themes.SecurityBaseActivity;
import com.msm.themes.ThemeUtil;
import com.msm.themes.interfaces.CheckVersionApp;
import com.msm.themes.util.themePreferencia;


public class ConfigActivity extends BaseActivity {
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





	}

	// PASSO 3: Inflar o menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu); // Usa o R.menu.main que você criou
		return true; // Retorna true para que o menu seja exibido
	}

	// PASSO 4: Lidar com cliques nos itens do menu
	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		// Lida com cliques nos itens da action bar aqui.
		// A action bar automaticamente lida com cliques no botão Home/Up,
		// desde que você especifique uma parent activity no AndroidManifest.xml.
		int id = item.getItemId();

		if (id == R.id.action_settings) {
			Toast.makeText(this, "Configurações clicado!", Toast.LENGTH_SHORT).show();
			// Adicione aqui a lógica para abrir sua tela de configurações
			return true;
		} else if (id == R.id.action_search) {
			Toast.makeText(this, "Buscar clicado!", Toast.LENGTH_SHORT).show();
			// Adicione aqui a lógica para a ação de busca
			return true;
		}

		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onResume() {
		super.onResume();
		checkInternet(this);
	}
}

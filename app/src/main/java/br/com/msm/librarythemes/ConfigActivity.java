package br.com.msm.librarythemes;

import static com.msm.themes.util.Util.Progress;
import static com.msm.themes.util.Util.ajustarLayout;
import static com.msm.themes.util.Util.checkInternet;
import static com.msm.themes.util.Util.showAviso;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.msm.themes.BaseActivity;
import com.techiness.progressdialoglibrary.ProgressDialog;


public class ConfigActivity extends BaseActivity {

    Context ctx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ctx =  this;

         NestedScrollView nestedScrollView = findViewById(R.id.nested_scroll_content); // Dê um ID ao seu NestedScrollView em content_main2.xml
         ajustarLayout(nestedScrollView);
         ProgressDialog pg = Progress(this);




        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                pg.show();

            }
        });

        findViewById(R.id.outlinedButton).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                pg.dismiss();

            }
        });

        findViewById(R.id.borderless).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
              showAviso(ctx, null, "Title", "Mensagem");

            }
        });


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

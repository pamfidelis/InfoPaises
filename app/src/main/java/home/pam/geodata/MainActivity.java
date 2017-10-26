package home.pam.geodata;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;

/**
 * Created by Pamela on 10/09/2017.
 * RA: 81523345
 */

public class MainActivity extends Activity {

    public static final String URL = "https://restcountries.eu/rest/v2/";
    public static final  String PAISES = "home.pam.geodata.pais";

    Pais[] paises;
    Button btn_buscar;
    Spinner spinner;
    ProgressBar timer;
    Intent intent;
    String continente = "all";

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        spinner = (Spinner) findViewById(R.id.spinner_id);
        spinner.setOnItemSelectedListener(new RegiaoSelecionada());

        timer = (ProgressBar)findViewById(R.id.timer);
        timer.setVisibility(View.INVISIBLE);
    }

    public void listarPaises(View view) {
        intent = new Intent(this, ListaPaisesActivity.class);
        if(InfoPaisNetwork.isConnected(this)) {
            timer.setVisibility(View.VISIBLE);
            new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                paises = InfoPaisNetwork.buscarPaises(URL, continente);

                                PaisesDb db = new PaisesDb(context);
                                db.inserirPaises(paises);
                                runOnUiThread(new Runnable() {
                                                  @Override
                                                  public void run() {
                                                      intent.putExtra(PAISES, paises);
                                                      startActivity(intent);
                                                      timer.setVisibility(View.INVISIBLE);
                                                  }
                                              }
                                );
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
        } else {
            Toast.makeText(this, "Rede inativa.",
                    Toast.LENGTH_SHORT).show();
            Log.d("banco", "Erro internet");
            new CarregarPaisesDoBanco().execute("pais");
        }
    }

    private class RegiaoSelecionada implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            continente = (String) parent.getItemAtPosition(position);
            if (continente.equals("Todos")) {
                continente = "all";
            } else {
                continente = "region/"+continente.toLowerCase();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
    private class CarregarPaisesDoBanco extends AsyncTask<String, Void, Pais[]> {
        @Override
        protected Pais[] doInBackground(String... params) {
            Log.d("banco", "Main Carregar pais");
            PaisesDb db = new PaisesDb(context);
            Pais[] paises = db.selecionarPaises();
            return paises;
        }

        public void onPostExecute(Pais[] paises){
            intent.putExtra(PAISES, paises);
            startActivity(intent);
        }
    }
}

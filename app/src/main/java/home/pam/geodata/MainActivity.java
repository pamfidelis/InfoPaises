package home.pam.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.spinner_id);
        spinner.setOnItemSelectedListener(new RegiaoSelecionada());

        btn_buscar = (Button) findViewById(R.id.btn_busca);

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
            Toast.makeText(this, "Rede inativa.", Toast.LENGTH_SHORT).show();
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
}

package home.pam.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Pamela on 10/09/2017.
 * RA: 81523345
 */

public class ListaPaisesActivity extends Activity {

    String continente;
    ListView listView;
    ArrayList<String> nomes;
    Pais[] lista;
    PaisDAO paisDAO;
    PaisesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        Intent intent = getIntent();
        continente = intent.getStringExtra("continente");

        listView = (ListView) findViewById(R.id.lista_paises);

        lista = paisDAO.listarPaises(continente);
        nomes = paisDAO.listarNomes(lista);

        adapter = new PaisesAdapter(lista, this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetalhePaisActivity.class);
                intent.putExtra("id", lista[position]);

                startActivity(intent);
            }
        });
    }
}

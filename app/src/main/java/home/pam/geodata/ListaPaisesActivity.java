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
 */

public class ListaPaisesActivity extends Activity {

    ListView listView;
    ArrayAdapter<String> adapter;
    ArrayList<String> lista;
    Pais pais = new Pais();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        Intent intent = getIntent();

        String nome_pais = intent.getStringExtra("pais");

        listView = (ListView) findViewById(R.id.lista_paises);

        lista = pais.buscarPais(nome_pais);

        adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetalhePaisActivity.class);
                intent.putExtra("id", lista.get(position));

                startActivity(intent);
            }
        });
    }
}

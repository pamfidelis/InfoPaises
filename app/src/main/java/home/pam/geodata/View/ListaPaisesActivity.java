package home.pam.geodata.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import home.pam.geodata.Model.Pais;
import home.pam.geodata.R;
import home.pam.geodata.Util.PaisesAdapter;

/**
 * Created by Pamela on 10/09/2017.
 * RA: 81523345
 */

public class ListaPaisesActivity extends Activity {

    public static final  String PAIS = "home.pam.geodata.pais";
    ListView listView;
    Pais[] paises;
    PaisesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_paises);

        Intent intent = getIntent();

        paises = (Pais[]) intent.getSerializableExtra(MainActivity.PAISES);

        adapter = new PaisesAdapter(paises, this);

        listView = (ListView) findViewById(R.id.lista_paises);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getApplicationContext(), DetalhePaisActivity.class);
                intent.putExtra(PAIS, paises[position]);

                startActivity(intent);
            }
        });
    }
}

package home.pam.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Pamela on 10/09/2017.
 */

public class MainActivity extends Activity {

    Button btn_buscar;
    EditText txt_pais;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_pais = (EditText) findViewById(R.id.txtPais);
        btn_buscar = (Button) findViewById(R.id.btn_busca);

        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaPaisesActivity.class);

                intent.putExtra("pais", txt_pais.getText().toString());

                startActivity(intent);

            }
        });

    }
}

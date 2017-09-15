package home.pam.geodata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Pamela on 10/09/2017.
 * RA: 81523345
 */
public class DetalhePaisActivity extends Activity {

    private TextView txtDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        Intent intent = getIntent();

        Pais pais = (Pais)intent.getSerializableExtra("id");

        txtDetalhe = (TextView) findViewById(R.id.txtDetalhe);
        txtDetalhe.setText(pais.toString());

    }
}
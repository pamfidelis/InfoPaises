package home.pam.geodata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Pamela on 10/09/2017.
 */
public class DetalhePaisActivity extends Activity {

    private TextView txtDetalhe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        Intent intent = getIntent();

        String nome_pais = intent.getStringExtra("id");

        txtDetalhe = (TextView) findViewById(R.id.txtDetalhe);
        txtDetalhe.setText(nome_pais);
    }

    public void voltar (){
        this.finish();
    }
}

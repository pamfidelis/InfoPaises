package home.pam.geodata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pamela on 10/09/2017.
 * RA: 81523345
 */
public class DetalhePaisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_pais);

        Intent intent = getIntent();

        Pais pais = (Pais)intent.getSerializableExtra(ListaPaisesActivity.PAIS);

        ImageView bandeira = (ImageView)findViewById(R.id.img_bandeira_pais);
        bandeira.setImageDrawable(Util.getDrawable(this, pais.getCodigo3().toLowerCase()));

        TextView nome = (TextView)findViewById(R.id.txt_nome_pais);
        nome.setText(pais.getNome());

        TextView capital = (TextView)findViewById(R.id.txt_capital);
        capital.setText(pais.getCapital());

        TextView regiao = (TextView)findViewById(R.id.txt_regiao);
        regiao.setText(pais.getRegiao());

     /*   TextView subregiao = (TextView)findViewById(R.id.txt_subregiao);
        subregiao.setText(pais.getSubRegiao());

        TextView demonimo = (TextView)findViewById(R.id.txt_demonimo);
        demonimo.setText(pais.getDemonimo());

        TextView area = (TextView)findViewById(R.id.txt_area);
        area.setText(String.format("%1$,d km\u00b2", pais.getArea()));

        TextView populacao = (TextView)findViewById(R.id.txt_populacao);
        populacao.setText(String.format("%1$,d", pais.getPopulacao()));

        TextView gini = (TextView) findViewById(R.id.txt_gini);
        gini.setText(String.format("%.2f", pais.getGini()));

        TextView latitude = (TextView) findViewById(R.id.txt_latitude);
        latitude.setText(String.format("%.2f", pais.getLatitude()));

        TextView longitude = (TextView) findViewById(R.id.txt_longitude);
        longitude.setText(String.format("%.2f", pais.getLongitude()));

        TextView idiomas = (TextView) findViewById(R.id.txt_idiomas);

        String word = "";

        for(int i = 0; i < pais.getIdiomas().size(); i++ ){
            word += pais.getIdiomas().get(i) + "   ";
        }
        idiomas.setText(word);

        TextView fuso_horario = (TextView) findViewById(R.id.txt_fusos);

        word = "";

        for(int i = 0; i < pais.getIdiomas().size(); i++ ){
            word += pais.getFusos().get(i) + "   ";
        }
        fuso_horario.setText(word);

        TextView dominios = (TextView) findViewById(R.id.txt_dominio);
        word = "";

        for(int i = 0; i < pais.getDominios().size(); i++ ){
            word += pais.getDominios().get(i) + "   ";
        }
        dominios.setText(word);

        TextView moeda = (TextView) findViewById(R.id.txt_moeda);
        word = "";

        for(int i = 0; i < pais.getMoedas().size(); i++ ){
            word += pais.getMoedas().get(i) + "   ";
        }
        moeda.setText(word);

        TextView fronteiras = (TextView) findViewById(R.id.txt_fronteiras);
        word = "";

        for(int i = 0; i < pais.getFronteiras().size(); i++ ){
            word += pais.getFronteiras().get(i) + "   ";
        }
        fronteiras.setText(word); */
    }
}

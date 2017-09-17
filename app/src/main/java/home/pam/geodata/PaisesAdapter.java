package home.pam.geodata;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Pamela on 16/09/2017.
 */

public class PaisesAdapter extends BaseAdapter {

    private Pais[] paises;
    private PaisDAO dao;
    private Activity activity;

    public PaisesAdapter(Pais[] paises, Activity activity) {
        this.paises = paises;
        this.activity = activity;
    }

    /* Conta quantas linhas tem */
    @Override
    public int getCount() {
        return paises.length;
    }

    @Override
    public Object getItem(int position) {
        return paises[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * layout = layout que será inflado,
         * parent = o layout pai que será adicionado a view
         * boolean = sea view será criada no momento
         */
        View view = activity.getLayoutInflater().inflate(R.layout.linha_paises, parent, false);

        ImageView image = (ImageView) view.findViewById(R.id.bandeira);
        TextView txt_nome_pais = (TextView) view.findViewById(R.id.txt_nome_pais);
        TextView txt_detalhe = (TextView) view.findViewById(R.id.txt_detalhe);

        image.setImageResource(R.drawable.pirata);
        txt_nome_pais.setText(paises[position].getNome());

        String detalhe = "região: " + paises[position].getRegiao() + " - capital: " + paises[position].getCapital();
        txt_detalhe.setText(detalhe);

        return view;
    }
}

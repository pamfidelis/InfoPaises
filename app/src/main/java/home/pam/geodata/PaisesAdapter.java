package home.pam.geodata;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by Pamela on 16/09/2017.
 */

public class PaisesAdapter extends BaseAdapter implements SectionIndexer {

    private Pais[] paises;
    private Activity activity;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public PaisesAdapter(Pais[] paises, Activity activity) {
        this.paises = paises;
        this.activity = activity;
        sectionHeaders = SectionIndexBuilder.buildSectionHeaders(paises);
        positionForSectionMap = SectionIndexBuilder.buildPositionForSectionMap(paises);
        sectionForPositionMap = SectionIndexBuilder.buildSectionForPositionMap(paises);
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
         * boolean =  view que será criada no momento
         */
        View view = convertView;

        if (view == null){
            view =    activity.getLayoutInflater().inflate(R.layout.linha_paises, parent, false);

            ImageView bandeira = (ImageView) view.findViewById(R.id.bandeira);
            TextView txt_nome_pais = (TextView) view.findViewById(R.id.txt_nome_pais);
            TextView txt_detalhe = (TextView) view.findViewById(R.id.detalhe);

            ViewHolder viewHolder = new ViewHolder(bandeira, txt_nome_pais, txt_detalhe);

            view.setTag(viewHolder);
        }
        String detalhe = "região: " + paises[position].getRegiao() + " - capital: " + paises[position].getCapital();

        ViewHolder viewHolder = (ViewHolder) view.getTag();

        viewHolder.getNome().setText(paises[position].getNome());
        viewHolder.getDetalhe().setText(detalhe);

        Drawable drawable = Util.getDrawable(activity, paises[position].getCodigo3().toLowerCase());
        if(drawable == null){
            drawable = activity.getDrawable(R.drawable.pirata);
        }
        viewHolder.getBandeira().setImageDrawable(drawable);

        return view;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return 0;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}

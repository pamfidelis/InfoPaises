package home.pam.geodata.View;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Pamela Fidelis on 22/09/2017.
 * Objetivo: Guardar as views
 */

public class ViewHolder {

    ImageView bandeira;
    TextView nome;
    TextView detalhe;

    public ViewHolder(ImageView bandeira, TextView nome, TextView txt_detalhe) {
        this.bandeira = bandeira;
        this.nome = nome;
        this.detalhe = txt_detalhe;
    }

    public ImageView getBandeira() {
        return bandeira;
    }

    public void setBandeira(ImageView bandeira) {
        this.bandeira = bandeira;
    }

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(TextView detalhe) {
        this.detalhe = detalhe;
    }
}

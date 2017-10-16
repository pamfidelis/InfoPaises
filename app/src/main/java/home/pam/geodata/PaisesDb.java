package home.pam.geodata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Pâmela Fidelis on 16/10/2017.
 */

public class PaisesDb {

    PaisesDbHelper dbHelper;

    public PaisesDb(Context contexto){
        dbHelper = new PaisesDbHelper(contexto);
    }

    public void inserirPaises(Pais[] paises){
        // Abre o banco para escrita
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        //Melhorar o código
        db.delete(PaisesContract.PaisEntry.TABLE_NAME, null, null);

        for (Pais pais:paises) {
            //Campo e valor da tabela
            ContentValues values = new ContentValues();

            values.put(PaisesContract.PaisEntry.COLUMN_NOME, pais.getNome());
            values.put(PaisesContract.PaisEntry.COLUMN_REGIAO, pais.getRegiao());
            values.put(PaisesContract.PaisEntry.COLUMN_CAPITAL, pais.getCapital());
            values.put(PaisesContract.PaisEntry.COLUMN_BANDEIRA, pais.getBandeira());
            values.put(PaisesContract.PaisEntry.COLUMN_CODIGO3, pais.getCodigo3());

            // Parâmetros: Nome da tabela, caso não tenha valor, valores
            db.insert(PaisesContract.PaisEntry.TABLE_NAME, null, values);
        }
    }

    public Pais[] selecionarPaises(){
        // Leitura
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        ArrayList<Pais> paises = new ArrayList<>();

        String[] colunas = {
                PaisesContract.PaisEntry.COLUMN_NOME,
                PaisesContract.PaisEntry.COLUMN_REGIAO,
                PaisesContract.PaisEntry.COLUMN_CAPITAL,
                PaisesContract.PaisEntry.COLUMN_BANDEIRA,
                PaisesContract.PaisEntry.COLUMN_CODIGO3};

        String ordem = PaisesContract.PaisEntry.COLUMN_NOME;

        //Parâmetros: nome da tabela, colunas, where, valor do where, orderby, groupby, having
        Cursor c = db.query(PaisesContract.PaisEntry.TABLE_NAME, colunas, null, null, ordem, null,null);

        while (c.moveToNext()){
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NOME)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_REGIAO)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_CAPITAL)));
            pais.setBandeira(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_BANDEIRA)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_CODIGO3)));

            paises.add(pais);
        }
        c.close();

        if (paises.size() > 0){
            return paises.toArray(new Pais[0]);
        }else {
            return new Pais[0];
        }
    }
}
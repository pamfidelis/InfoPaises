package home.pam.geodata;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        /*
         * melhorar o codigo verificando a regiao que se quer inserir
         * e as regioes existentes na tabela antes de decidir o que
         * deletar
         */
        db.delete(PaisesContract.PaisEntry.TABLE_NAME, null, null);

        for(Pais pais:paises){
            ContentValues values = new ContentValues();
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_NOME, pais.getNome());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_REGIAO, pais.getRegiao());
           // values.put(PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO, pais.getSubRegiao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL, pais.getCapital());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA, pais.getBandeira());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3, pais.getCodigo3());
            //values.put(PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO, pais.getDemonimo());

            db.insert(PaisesContract.PaisEntry.TABLE_NAME, null, values);
        }
    }

    public Pais[] selecionarPaises(){
        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = { PaisesContract.PaisEntry.COLUMN_NAME_NOME,
                PaisesContract.PaisEntry.COLUMN_NAME_REGIAO,
              //  PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO,
                PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL,
                PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA,
                PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3};
                //PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO};
        String ordem = PaisesContract.PaisEntry.COLUMN_NAME_NOME;

        Cursor c = db.query(PaisesContract.PaisEntry.TABLE_NAME, colunas, null, null,
                ordem, null, null);
        while(c.moveToNext()) {
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_NOME)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_REGIAO)));
            //pais.setRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL)));
            pais.setBandeira(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3)));
            //pais.setDemonimo(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO)));

            paises.add(pais);
        }
        c.close();
        if(paises.size()> 0) {
            return paises.toArray(new Pais[0]);
        } else {
            return new Pais[0];
        }
    }
}

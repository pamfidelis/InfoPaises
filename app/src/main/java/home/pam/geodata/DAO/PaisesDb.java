package home.pam.geodata.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import home.pam.geodata.Model.Pais;

/**
 * Created by Pâmela Fidelis on 16/10/2017.
 */

public class PaisesDb {
    PaisesDbHelper dbHelper;

    public PaisesDb(Context contexto) {
        dbHelper = new PaisesDbHelper(contexto);
    }

    public void inserirPaises(Pais[] paises) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        /*
         * melhorar o codigo verificando a regiao que se quer inserir
         * e as regioes existentes na tabela antes de decidir o que
         * deletar
         */
        db.delete(PaisesContract.PaisLanguage.TABLE_NAME, null, null);
        db.delete(PaisesContract.PaisEntry.TABLE_NAME, null, null);
        db.delete(PaisesContract.Language.TABLE_NAME, null, null);

        for (Pais pais : paises) {
            ContentValues values = new ContentValues();
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_NOME, pais.getNome());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_REGIAO, pais.getRegiao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO, pais.getSubRegiao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL, pais.getCapital());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA, pais.getBandeira());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3, pais.getCodigo3());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO, pais.getDemonimo());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_AREA, pais.getArea());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO, pais.getPopulacao());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_GINI, pais.getGini());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE, pais.getLatitude());
            values.put(PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE, pais.getLongitude());

            ContentValues values_language = new ContentValues();
            ContentValues values_pais_language = new ContentValues();

            ArrayList<String> lista_idiomas = pais.getIdiomas();

            // Log.d("idioma", "Idioma: " + lista_idiomas.toString());

            int tamanho_idioma = lista_idiomas.size() - 1;

            long[] idioma_id = new long[tamanho_idioma+1];
            Log.d("idioma", "Tamanho do vetor de idiomas " + idioma_id.length);
            int i = 0;

            db.beginTransaction();
            try {
                Log.d("idioma", "tamanho do while: " + tamanho_idioma);

                while (i <= tamanho_idioma) {
                    Log.d("idioma", "I: " + i);
                    Log.d("idioma", "Tamanho do vetor de idiomas " + idioma_id.length);
                    values_language.put(PaisesContract.Language.COLUMN_NAME_IDIOMA, lista_idiomas.get(i));
                    idioma_id[i] = db.insert(PaisesContract.Language.TABLE_NAME, null, values_language);
                    Log.d("idioma", "Está inserindo o idioma: " + idioma_id[i]);
                    i++;
                }
                long id_pais = db.insert(PaisesContract.PaisEntry.TABLE_NAME, null, values);

                i = 0;
                while (i <= tamanho_idioma) {
                    Log.d("idioma", "I: " + i);
                    Log.d("idioma", "ID: " + idioma_id[i]);
                    Log.d("idioma", "Pais: " + id_pais);

                    Log.d("idioma", PaisesContract.PaisLanguage.COLUMN_NAME_PAIS);

                    values_pais_language.put(PaisesContract.PaisLanguage.COLUMN_NAME_PAIS, id_pais);
                    values_pais_language.put(PaisesContract.PaisLanguage.COLUMN_NAME_IDIOMA, idioma_id[i]);

                    Log.d("idioma", "Pais: " + values_pais_language.toString());

                    db.insert(PaisesContract.PaisLanguage.TABLE_NAME, null, values_pais_language);

                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("idioma", "Deu errado");
            } finally {
                Log.d("idioma", "Deu certo");
                db.endTransaction();
            }
        }
        Log.d("banco", "Inseriu os dados  na tabela");
    }

    public Pais[] selecionarPaises() {
        ArrayList<Pais> paises = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {PaisesContract.PaisEntry.COLUMN_NAME_NOME,
                PaisesContract.PaisEntry.COLUMN_NAME_REGIAO,
                PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO,
                PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL,
                PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA,
                PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3,
                PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO,
                PaisesContract.PaisEntry.COLUMN_NAME_AREA,
                PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO,
                PaisesContract.PaisEntry.COLUMN_NAME_GINI,
                PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE,
                PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE};

        String ordem = PaisesContract.PaisEntry.COLUMN_NAME_NOME;

        Cursor c = db.query(PaisesContract.PaisEntry.TABLE_NAME, colunas, null, null,
                ordem, null, null);
        while (c.moveToNext()) {
            Pais pais = new Pais();
            pais.setNome(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_NOME)));
            pais.setRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_REGIAO)));
            pais.setSubRegiao(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO)));
            pais.setCapital(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL)));
            pais.setBandeira(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA)));
            pais.setCodigo3(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3)));
            pais.setDemonimo(c.getString(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO)));
            pais.setArea(c.getInt(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_AREA)));
            pais.setPopulacao(c.getInt(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO)));
            pais.setGini(c.getDouble(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_GINI)));
            pais.setLatitude(c.getDouble(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE)));
            pais.setLongitude(c.getDouble(c.getColumnIndex(PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE)));

            paises.add(pais);
        }
        Log.d("banco", "Buscou os dados");
        c.close();
        if (paises.size() > 0) {
            return paises.toArray(new Pais[0]);
        } else {
            return new Pais[0];
        }
    }
}

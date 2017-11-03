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
            int size_array;
            long[] componente_id;
            int count;
            ArrayList<String> arrayList;

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

            long id_pais = db.insert(PaisesContract.PaisEntry.TABLE_NAME, null, values);

            ContentValues values_dominio = new ContentValues();
            ContentValues values_pais_dominio = new ContentValues();

            ContentValues values_fronteira = new ContentValues();
            ContentValues values_pais_fronteira = new ContentValues();

            ContentValues values_fuso = new ContentValues();
            ContentValues values_pais_fuso = new ContentValues();

            ContentValues values_moeda = new ContentValues();
            ContentValues values_pais_moeda = new ContentValues();

            arrayList = pais.getIdiomas();

            size_array = arrayList.size() - 1;

            componente_id = new long[size_array + 1];
            Log.d("idioma", "Tamanho do vetor de idiomas " + componente_id.length);
            count = 0;

            db.beginTransaction();
            try {
                Log.d("idioma", "tamanho do while: " + size_array);
                /* ---------------------- INSERINDO OS IDIOMAS NO BANCO ---------------------- */
                values = new ContentValues();
                while (count <= size_array) {
                    Log.d("idioma", "I: " + count);
                    Log.d("idioma", "Tamanho do vetor de idiomas " + componente_id.length);
                    values.put(PaisesContract.Language.COLUMN_NAME_IDIOMA, arrayList.get(count));
                    componente_id[count] = db.insert(PaisesContract.Language.TABLE_NAME, null, values);
                    Log.d("idioma", "Está inserindo o idioma: " + componente_id[count]);
                    count++;
                }
                values = new ContentValues();
                count = 0;
                while (count <= size_array) {
                    Log.d("idioma", "I: " + count);
                    Log.d("idioma", "ID: " + componente_id[count]);
                    Log.d("idioma", "Pais: " + id_pais);

                    Log.d("idioma", PaisesContract.PaisLanguage.COLUMN_NAME_PAIS);

                    values.put(PaisesContract.PaisLanguage.COLUMN_NAME_PAIS, id_pais);
                    values.put(PaisesContract.PaisLanguage.COLUMN_NAME_IDIOMA, componente_id[count]);

                    Log.d("idioma", "Pais: " + values.toString());

                    db.insert(PaisesContract.PaisLanguage.TABLE_NAME, null, values);
                    count++;
                }

                /* ---------------------- INSERINDO OS DOMINIOS NO BANCO ---------------------- */

                arrayList = pais.getDominios();
                size_array = arrayList.size() - 1;
                componente_id = new long[size_array + 1];
                Log.d("dominio", "Tamanho do vetor de dominios " + componente_id.length);
                count = 0;

                values = new ContentValues();
                while (count <= size_array) {
                    Log.d("Dominio", "I: " + count);
                    Log.d("Dominio", "Tamanho do vetor de dominio " + componente_id.length);
                    values.put(PaisesContract.Dominio.COLUMN_NAME_DOMINIO, arrayList.get(count));
                    componente_id[count] = db.insert(PaisesContract.Dominio.TABLE_NAME, null, values);
                    Log.d("idioma", "Está inserindo o dominio: " + componente_id[count]);
                    count++;
                }

                values = new ContentValues();
                count = 0;
                while (count <= size_array) {
                    Log.d("dominio", "I: " + count);
                    Log.d("dominio", "ID: " + componente_id[count]);
                    Log.d("dominio", "Pais: " + id_pais);

                    Log.d("dominio", PaisesContract.PaisLanguage.COLUMN_NAME_PAIS);

                    values.put(PaisesContract.PaisDominio.COLUMN_NAME_PAIS, id_pais);
                    values.put(PaisesContract.PaisDominio.COLUMN_NAME_DOMINIO, componente_id[count]);

                    Log.d("dominio", "Pais: " + values.toString());

                    db.insert(PaisesContract.PaisDominio.TABLE_NAME, null, values);
                    count++;
                }

                /* ---------------------- INSERINDO OS FUSOS NO BANCO ---------------------- */

                arrayList = pais.getFusos();
                size_array = arrayList.size() - 1;
                componente_id = new long[size_array + 1];
                Log.d("fuso", "Tamanho do vetor de dominios " + componente_id.length);
                count = 0;

                values = new ContentValues();
                while (count <= size_array) {
                    Log.d("fuso", "I: " + count);
                    Log.d("fuso", "Tamanho do vetor de fuso " + componente_id.length);
                    values.put(PaisesContract.Fuso.COLUMN_NAME_FUSO, arrayList.get(count));
                    componente_id[count] = db.insert(PaisesContract.Fuso.TABLE_NAME, null, values);
                    Log.d("fuso", "Está inserindo o fuso: " + componente_id[count]);
                    count++;
                }

                values = new ContentValues();
                count = 0;
                while (count <= size_array) {
                    Log.d("fuso", "I: " + count);
                    Log.d("fuso", "ID: " + componente_id[count]);
                    Log.d("fuso", "Pais: " + id_pais);

                    Log.d("fuso", PaisesContract.PaisFuso.COLUMN_NAME_PAIS);

                    values.put(PaisesContract.PaisFuso.COLUMN_NAME_PAIS, id_pais);
                    values.put(PaisesContract.PaisFuso.COLUMN_NAME_FUSO, componente_id[count]);

                    Log.d("fuso", "Pais: " + values.toString());

                    db.insert(PaisesContract.PaisFuso.TABLE_NAME, null, values);
                    count++;
                }

                /* ---------------------- INSERINDO AS FRONTEIRAS NO BANCO ---------------------- */

                arrayList = pais.getFronteiras();
                size_array = arrayList.size() - 1;
                componente_id = new long[size_array + 1];
                // Log.d("fronteira", "Tamanho do vetor de dominios " + componente_id.length);

                count = 0;
                values = new ContentValues();
                while (count <= size_array) {
                   /* Log.d("fronteira", "I: " + count); */
                    values.put(PaisesContract.Fronteira.COLUMN_NAME_FRONTEIRA, arrayList.get(count));
                    componente_id[count] = db.insert(PaisesContract.Fronteira.TABLE_NAME, null, values);
                    // Log.d("fronteira", "Está inserindo a fronteira: " + componente_id[count]);
                    count++;
                }

                values = new ContentValues();
                count = 0;
                while (count <= size_array) {
                    /* Log.d("fronteira", "I: " + count);
                    Log.d("fronteira", "ID: " + componente_id[count]);
                    Log.d("fronteira", "Pais: " + id_pais);

                    Log.d("fronteira", PaisesContract.PaisFronteira.COLUMN_NAME_PAIS); */

                    values.put(PaisesContract.PaisFronteira.COLUMN_NAME_PAIS, id_pais);
                    values.put(PaisesContract.PaisFronteira.COLUMN_NAME_FRONTEIRA, componente_id[count]);

                    db.insert(PaisesContract.PaisFronteira.TABLE_NAME, null, values);

                    //Log.d("fronteira", "inseriu");
                    count++;
                }

                /* ---------------------- INSERINDO AS MOEDAS NO BANCO ---------------------- */

                arrayList = pais.getMoedas();
                size_array = arrayList.size() - 1;
                componente_id = new long[size_array + 1];
                Log.d("moeda", "Tamanho do vetor de moedas " + componente_id.length);

                count = 0;
                values = new ContentValues();
                while (count <= size_array) {
                   Log.d("moeda", "I: " + count);
                    values.put(PaisesContract.Moeda.COLUMN_NAME_MOEDA, arrayList.get(count));
                    componente_id[count] = db.insert(PaisesContract.Moeda.TABLE_NAME, null, values);
                    Log.d("moeda", "Está inserindo a moeda: " + componente_id[count]);
                    count++;
                }

                values = new ContentValues();
                count = 0;
                while (count <= size_array) {
                    Log.d("moeda", "I: " + count);
                    Log.d("moeda", "ID: " + componente_id[count]);
                    Log.d("moeda", "Pais: " + id_pais);

                    Log.d("moeda", PaisesContract.PaisMoeda.COLUMN_NAME_PAIS);

                    values.put(PaisesContract.PaisMoeda.COLUMN_NAME_PAIS, id_pais);
                    values.put(PaisesContract.PaisMoeda.COLUMN_NAME_MOEDA, componente_id[count]);

                    db.insert(PaisesContract.PaisMoeda.TABLE_NAME, null, values);

                    Log.d("moeda", "inseriu");
                    count++;
                }
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("banco", "Deu errado");
            } finally {
                Log.d("banco", "Deu certo");
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

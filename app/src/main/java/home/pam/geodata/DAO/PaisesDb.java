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
    SQLiteDatabase db;

    public PaisesDb(Context contexto) {
        dbHelper = new PaisesDbHelper(contexto);
    }

    public void inserirPaises(Pais[] paises) {
        db = dbHelper.getWritableDatabase();

        deletarTabelas();

        for (Pais pais : paises) {
            ContentValues values = new ContentValues();

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
            Log.d("pais", "ID --------------" + id_pais);
            arrayList = pais.getIdiomas();

            inserirIdiomas(arrayList, id_pais);

            arrayList = pais.getDominios();
            inserirDominios(arrayList, id_pais);

            arrayList = pais.getFronteiras();
            inserirFronteiras(arrayList, id_pais);

            arrayList = pais.getFusos();
            inserirFusos(arrayList, id_pais);

            arrayList = pais.getMoedas();
            inserirMoedas(arrayList, id_pais);
        }
    }

    public void inserirIdiomas(ArrayList<String> idiomas, long id_pais) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            for (String idioma : idiomas) {
                values.put(PaisesContract.Language.COLUMN_NAME_IDIOMA, idioma);
                long id_idioma = db.insert(PaisesContract.Language.TABLE_NAME, null, values);

                inserirPaisIdiomas(id_pais, id_idioma);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado idioma");
        } finally {
            Log.d("banco", "Deu certo idioma");
            db.endTransaction();
        }
    }

    public void inserirPaisIdiomas(long id_pais, long id_idioma) {
        db = dbHelper.getReadableDatabase();

        Log.d("id", "----Inserir Idioma " + id_idioma);
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(PaisesContract.PaisLanguage.COLUMN_NAME_PAIS, id_pais);
            values.put(PaisesContract.PaisLanguage.COLUMN_NAME_IDIOMA, id_idioma);
            db.insert(PaisesContract.PaisLanguage.TABLE_NAME, null, values);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado Idioma Pais");
        } finally {
            Log.d("banco", "Deu certo Idioma Pais");
            db.endTransaction();
        }
    }

    public void inserirDominios(ArrayList<String> dominios, long id_pais) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            for (String dominio : dominios) {
                values.put(PaisesContract.Dominio.COLUMN_NAME_DOMINIO, dominio);
                long id_dominio = db.insert(PaisesContract.Dominio.TABLE_NAME, null, values);

                inserirPaisDominios(id_pais, id_dominio);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado dominio");
        } finally {
            Log.d("banco", "Deu certo dominio");
            db.endTransaction();
        }
    }

    public void inserirPaisDominios(long id_pais, long id_dominio) {
        db = dbHelper.getReadableDatabase();
        Log.d("id", "----Inserir Dominio " + id_dominio);
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(PaisesContract.PaisDominio.COLUMN_NAME_PAIS, id_pais);
            values.put(PaisesContract.PaisDominio.COLUMN_NAME_DOMINIO, id_dominio);
            db.insert(PaisesContract.PaisDominio.TABLE_NAME, null, values);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado Dominio Pais");
        } finally {
            Log.d("banco", "Deu certo Dominio Pais");
            db.endTransaction();
        }
    }

    public void inserirFronteiras(ArrayList<String> fronteiras, long id_pais) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            for (String fronteira : fronteiras) {
                values.put(PaisesContract.Fronteira.COLUMN_NAME_FRONTEIRA, fronteira);
                long id_fronteira = db.insert(PaisesContract.Fronteira.TABLE_NAME, null, values);

                inserirPaisFronteiras(id_pais, id_fronteira);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado fronteira");
        } finally {
            Log.d("banco", "Deu certo fronteira");
            db.endTransaction();
        }
    }

    public void inserirPaisFronteiras(long id_pais, long id_fronteira) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(PaisesContract.PaisFronteira.COLUMN_NAME_PAIS, id_pais);
            values.put(PaisesContract.PaisFronteira.COLUMN_NAME_FRONTEIRA, id_fronteira);
            db.insert(PaisesContract.PaisFronteira.TABLE_NAME, null, values);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado Fronteira Pais");
        } finally {
            Log.d("banco", "Deu certo Fronteira Pais");
            db.endTransaction();
        }
    }

    public void inserirFusos(ArrayList<String> fusos, long id_pais) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            for (String fuso : fusos) {
                values.put(PaisesContract.Fuso.COLUMN_NAME_FUSO, fuso);
                long id_fuso = db.insert(PaisesContract.Fuso.TABLE_NAME, null, values);

                inserirPaisFusos(id_pais, id_fuso);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado fuso");
        } finally {
            Log.d("banco", "Deu certo fuso");
            db.endTransaction();
        }
    }

    public void inserirPaisFusos(long id_pais, long id_fuso) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(PaisesContract.PaisFuso.COLUMN_NAME_PAIS, id_pais);
            values.put(PaisesContract.PaisFuso.COLUMN_NAME_FUSO, id_fuso);
            db.insert(PaisesContract.PaisFuso.TABLE_NAME, null, values);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado Fuso Pais");
        } finally {
            Log.d("banco", "Deu certo Fuso Pais");
            db.endTransaction();
        }
    }

    public void inserirMoedas(ArrayList<String> moedas, long id_pais) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            for (String moeda : moedas) {
                values.put(PaisesContract.Moeda.COLUMN_NAME_MOEDA, moeda);
                long id_moeda = db.insert(PaisesContract.Moeda.TABLE_NAME, null, values);

                inserirPaisMoedas(id_pais, id_moeda);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado moeda");
        } finally {
            Log.d("banco", "Deu certo moeda");
            db.endTransaction();
        }
    }

    public void inserirPaisMoedas(long id_pais, long id_moeda) {
        db = dbHelper.getReadableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();

            values.put(PaisesContract.PaisMoeda.COLUMN_NAME_PAIS, id_pais);
            values.put(PaisesContract.PaisMoeda.COLUMN_NAME_MOEDA, id_moeda);
            db.insert(PaisesContract.PaisMoeda.TABLE_NAME, null, values);

        } catch (Exception e) {
            e.printStackTrace();
            Log.d("banco", "Deu errado Fuso Pais");
        } finally {
            Log.d("banco", "Deu certo Fuso Pais");
            db.endTransaction();
        }
    }

    public Pais[] selecionarPaises() {
        ArrayList<Pais> paises = new ArrayList<>();

        db = dbHelper.getReadableDatabase();

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
                PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE,
                PaisesContract.PaisEntry._ID};

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

            Log.d("pais", "Inicio do cursor");
            int id_pais = c.getInt(c.getColumnIndex(PaisesContract.PaisEntry._ID));
            Log.d("pais", "ID DO PAIS " + id_pais);

            ArrayList<String> lista = selecionarIdioma(id_pais);
            pais.setIdiomas(lista);

            ArrayList<String> dominios = selecionarDominio(id_pais);
            pais.setDominios(lista);

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

    public ArrayList<String> selecionarIdioma(int id) {
        ArrayList<String> idiomas = new ArrayList<>();
        Log.d("pais", "entrou");
        db = dbHelper.getReadableDatabase();

        String query = "SELECT " +
                "l." + PaisesContract.Language.COLUMN_NAME_IDIOMA +
                " FROM " + PaisesContract.PaisEntry.TABLE_NAME + " p " +
                " JOIN " + PaisesContract.PaisLanguage.TABLE_NAME + " pl " +
                " ON " + " pl." + PaisesContract.PaisLanguage._ID + " = " + " p." + PaisesContract.PaisEntry._ID +
                " JOIN " + PaisesContract.Language.TABLE_NAME + " l " +
                " ON " + " pl." + PaisesContract.PaisLanguage.COLUMN_NAME_IDIOMA + " = " + " l." + PaisesContract.Language._ID +
                " WHERE " + " p." + PaisesContract.PaisEntry._ID + " = " + id;


        Cursor c = db.rawQuery(query, null);
        Log.d("pais", "rodou a query");
        while (c.moveToNext()) {
            Log.d("idiomas", "aqui------------------------------");
            idiomas.add(c.getString(c.getColumnIndex(PaisesContract.Language.COLUMN_NAME_IDIOMA)));
            Log.d("idiomas", idiomas.toString());
        }
        return idiomas;
    }

    public ArrayList<String> selecionarDominio(int id) {
        ArrayList<String> dominios = new ArrayList<>();
        Log.d("pais", "entrou");
        db = dbHelper.getReadableDatabase();

        String query = "SELECT " +
                "d." + PaisesContract.Dominio.COLUMN_NAME_DOMINIO +
                " FROM " + PaisesContract.PaisEntry.TABLE_NAME + " p " +
                " JOIN " + PaisesContract.PaisDominio.TABLE_NAME + " pd " +
                " ON " + " pd." + PaisesContract.PaisDominio._ID + " = " + " p." + PaisesContract.PaisEntry._ID +
                " JOIN " + PaisesContract.Dominio.TABLE_NAME + " d " +
                " ON " + " pd." + PaisesContract.PaisDominio.COLUMN_NAME_DOMINIO + " = " + " d." + PaisesContract.Dominio._ID +
                " WHERE " + " p." + PaisesContract.PaisEntry._ID + " = " + id;

        Log.d("query", query);
        Cursor c = db.rawQuery(query, null);
        Log.d("pais", "rodou a query");
        while (c.moveToNext()) {
            Log.d("dominio", "Esses são os domínios");
            dominios.add(c.getString(c.getColumnIndex(PaisesContract.Dominio.COLUMN_NAME_DOMINIO)));
            Log.d("dominio", "Esses são os domínios" + dominios.toString());
        }
        return dominios;
    }

    public ArrayList<String> selecionarFronteira(int id) {
        ArrayList<String> fronteiras = new ArrayList<>();
        Log.d("pais", "entrou");
        db = dbHelper.getReadableDatabase();

        String query = "SELECT " +
                "f." + PaisesContract.Fronteira.COLUMN_NAME_FRONTEIRA +
                " FROM " + PaisesContract.PaisEntry.TABLE_NAME + " p " +
                " JOIN " + PaisesContract.PaisFronteira.TABLE_NAME + " pf " +
                " ON " + " pf." + PaisesContract.PaisFronteira._ID + " = " + " p." + PaisesContract.PaisEntry._ID +
                " JOIN " + PaisesContract.Fronteira.TABLE_NAME + " f " +
                " ON " + " pf." + PaisesContract.PaisFronteira.COLUMN_NAME_FRONTEIRA + " = " + " f." + PaisesContract.Fronteira._ID +
                " WHERE " + " p." + PaisesContract.PaisEntry._ID + " = " + id;

        Log.d("query", query);
        Cursor c = db.rawQuery(query, null);
        Log.d("pais", "rodou a query");
        while (c.moveToNext()) {
            Log.d("dominio", "Esses são as fronteiras");
            fronteiras.add(c.getString(c.getColumnIndex(PaisesContract.Fronteira.COLUMN_NAME_FRONTEIRA)));
            Log.d("dominio", "Esses são as fronteiras" + fronteiras.toString());
        }
        return fronteiras;
    }

    public ArrayList<String> selecionarFusos(int id) {
        ArrayList<String> fusos = new ArrayList<>();
        Log.d("pais", "entrou");
        db = dbHelper.getReadableDatabase();

        String query = "SELECT " +
                "f." + PaisesContract.Fuso.COLUMN_NAME_FUSO +
                " FROM " + PaisesContract.PaisEntry.TABLE_NAME + " p " +
                " JOIN " + PaisesContract.PaisFuso.TABLE_NAME + " pf " +
                " ON " + " pf." + PaisesContract.PaisFuso._ID + " = " + " p." + PaisesContract.PaisEntry._ID +
                " JOIN " + PaisesContract.Fuso.TABLE_NAME + " f " +
                " ON " + " pf." + PaisesContract.PaisFuso.COLUMN_NAME_FUSO+ " = " + " f." + PaisesContract.Fuso._ID +
                " WHERE " + " p." + PaisesContract.PaisEntry._ID + " = " + id;

        Log.d("query", query);
        Cursor c = db.rawQuery(query, null);
        Log.d("pais", "rodou a query");
        while (c.moveToNext()) {
            Log.d("dominio", "Esses são os fusos");
            fusos.add(c.getString(c.getColumnIndex(PaisesContract.Fuso.COLUMN_NAME_FUSO)));
            Log.d("dominio", "Esses são os fusos" + fusos.toString());
        }
        return fusos;
    }

    public ArrayList<String> selecionarMoedas(int id) {
        ArrayList<String> moedas = new ArrayList<>();
        Log.d("pais", "entrou");
        db = dbHelper.getReadableDatabase();

        String query = "SELECT " +
                "m." + PaisesContract.Moeda.COLUMN_NAME_MOEDA +
                " FROM " + PaisesContract.PaisEntry.TABLE_NAME + " p " +
                " JOIN " + PaisesContract.PaisMoeda.TABLE_NAME + " pm " +
                " ON " + " pm." + PaisesContract.PaisMoeda._ID + " = " + " p." + PaisesContract.PaisEntry._ID +
                " JOIN " + PaisesContract.Moeda.TABLE_NAME + " m " +
                " ON " + " pm." + PaisesContract.PaisMoeda.COLUMN_NAME_MOEDA + " = " + " m." + PaisesContract.Moeda._ID +
                " WHERE " + " p." + PaisesContract.PaisEntry._ID + " = " + id;

        Log.d("query", query);
        Cursor c = db.rawQuery(query, null);
        Log.d("pais", "rodou a query");
        while (c.moveToNext()) {
            Log.d("banco", "Essas são os moedas");
            moedas.add(c.getString(c.getColumnIndex(PaisesContract.Moeda.COLUMN_NAME_MOEDA)));
            Log.d("banco", "Essas são os moedas" + moedas.toString());
        }
        return moedas;
    }

    /* Melhor o código */
    public void deletarTabelas() {
        db = dbHelper.getWritableDatabase();

        db.delete(PaisesContract.PaisDominio.TABLE_NAME, null, null);
        db.delete(PaisesContract.PaisMoeda.TABLE_NAME, null, null);
        db.delete(PaisesContract.PaisLanguage.TABLE_NAME, null, null);
        db.delete(PaisesContract.PaisFuso.TABLE_NAME, null, null);
        db.delete(PaisesContract.PaisFronteira.TABLE_NAME, null, null);
        db.delete(PaisesContract.PaisEntry.TABLE_NAME, null, null);
        db.delete(PaisesContract.Language.TABLE_NAME, null, null);
        db.delete(PaisesContract.Moeda.TABLE_NAME, null, null);
        db.delete(PaisesContract.Dominio.TABLE_NAME, null, null);
        db.delete(PaisesContract.Fronteira.TABLE_NAME, null, null);
        db.delete(PaisesContract.Fuso.TABLE_NAME, null, null);
    }
}

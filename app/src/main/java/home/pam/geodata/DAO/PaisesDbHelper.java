package home.pam.geodata.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Pâmela Fidelis on 16/10/2017.
 */

public class PaisesDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Paises.db";

    public static final String SQL_CREATE_PAIS =
            "CREATE TABLE " + PaisesContract.PaisEntry.TABLE_NAME + "(" +
                    PaisesContract.PaisEntry._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisEntry.COLUMN_NAME_NOME + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_REGIAO + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_SUBREGIAO + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_CAPITAL + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_BANDEIRA + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_CODIGO3 + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_DEMONIMO + " TEXT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_AREA + " INT, " +
                    PaisesContract.PaisEntry.COLUMN_NAME_GINI + " REAL," +
                    PaisesContract.PaisEntry.COLUMN_NAME_POPULACAO + " INT," +
                    PaisesContract.PaisEntry.COLUMN_NAME_LATITUDE + " REAL," +
                    PaisesContract.PaisEntry.COLUMN_NAME_LONGITUDE + " REAL)";

    public static final String SQL_CREATE_IDIOMA =
            "CREATE TABLE " + PaisesContract.Language.TABLE_NAME + "(" +
                    PaisesContract.Language._ID + "INTEGER PRIMARY KEY," +
                    PaisesContract.Language.COLUMN_NAME_IDIOMA + " TEXT)";

    public static final String SQL_CREATE_PAIS_IDIOMA =
            "CREATE TABLE " + PaisesContract.PaisLanguage.TABLE_NAME + "(" +
                    PaisesContract.PaisLanguage._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisLanguage.COLUMN_NAME_PAIS + " INT," +
                    PaisesContract.PaisLanguage.COLUMN_NAME_IDIOMA + " INT)";

    public static final String SQL_CREATE_MOEDA =
            "CREATE TABLE " + PaisesContract.Moeda.TABLE_NAME + "(" +
                    PaisesContract.Moeda._ID + "INTEGER PRIMARY KEY," +
                    PaisesContract.Moeda.COLUMN_NAME_MOEDA + " TEXT," +
                    PaisesContract.Moeda.COLUMN_NAME_CODE + " TEXT)";

    public static final String SQL_CREATE_PAIS_MOEDA =
            "CREATE TABLE " + PaisesContract.PaisMoeda.TABLE_NAME + "(" +
                    PaisesContract.PaisMoeda._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisMoeda.COLUMN_NAME_PAIS + " INT," +
                    PaisesContract.PaisMoeda.COLUMN_NAME_MOEDA + " INT)";

    public static final String SQL_CREATE_DOMINIO =
            "CREATE TABLE " + PaisesContract.Dominio.TABLE_NAME + "(" +
                    PaisesContract.Dominio._ID + "INTEGER PRIMARY KEY," +
                    PaisesContract.Dominio.COLUMN_NAME_DOMINIO + " TEXT)";

    public static final String SQL_CREATE_PAIS_DOMINIO =
            "CREATE TABLE " + PaisesContract.PaisDominio.TABLE_NAME + "(" +
                    PaisesContract.PaisDominio._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisDominio.COLUMN_NAME_PAIS + " INT," +
                    PaisesContract.PaisDominio.COLUMN_NAME_DOMINIO + " INT)";

    public static final String SQL_CREATE_FUSO =
            "CREATE TABLE " + PaisesContract.Fuso.TABLE_NAME + "(" +
                    PaisesContract.Fuso._ID + " INTEGER PRIMARY KEY," +
                    PaisesContract.Fuso.COLUMN_NAME_FUSO + " TEXT)";

    public static final String SQL_CREATE_PAIS_FUSO =
            "CREATE TABLE " + PaisesContract.PaisFuso.TABLE_NAME + "(" +
                    PaisesContract.PaisFuso._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisFuso.COLUMN_NAME_PAIS + " INT," +
                    PaisesContract.PaisFuso.COLUMN_NAME_FUSO + " INT)";

    public static final String SQL_CREATE_FRONTEIRA =
            "CREATE TABLE " + PaisesContract.Fronteira.TABLE_NAME + "(" +
                    PaisesContract.Fronteira._ID + " INTEGER PRIMARY KEY," +
                    PaisesContract.Fronteira.COLUMN_NAME_FRONTEIRA + " TEXT)";

    public static final String SQL_CREATE_PAIS_FRONTEIRA =
            "CREATE TABLE " + PaisesContract.PaisFronteira.TABLE_NAME + "(" +
                    PaisesContract.PaisFronteira._ID + " INTEGER PRIMARY KEY,"+
                    PaisesContract.PaisFronteira.COLUMN_NAME_PAIS + " INT," +
                    PaisesContract.PaisFronteira.COLUMN_NAME_FRONTEIRA + " INT)";

    public static final String SQL_DROP_PAIS =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisEntry.TABLE_NAME;

    public static final String SQL_DROP_MOEDA =
            "DROP  TABLE IF EXISTS " + PaisesContract.Moeda.TABLE_NAME;

    public static final String SQL_DROP_PAIS_MOEDA =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisMoeda.TABLE_NAME;

    public static final String SQL_DROP_IDIOMA =
            "DROP  TABLE IF EXISTS " + PaisesContract.Language.TABLE_NAME;

    public static final String SQL_DROP_PAIS_IDIOMA =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisLanguage.TABLE_NAME;

    public static final String SQL_DROP_FRONTEIRA =
            "DROP  TABLE IF EXISTS " + PaisesContract.Fronteira.TABLE_NAME;

    public static final String SQL_DROP_PAIS_FRONTEIRA =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisFronteira.TABLE_NAME;

    public static final String SQL_DROP_DOMINIO =
            "DROP  TABLE IF EXISTS " + PaisesContract.Dominio.TABLE_NAME;

    public static final String SQL_DROP_PAIS_DOMINIO =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisDominio.TABLE_NAME;

    public static final String SQL_DROP_FUSO =
            "DROP  TABLE IF EXISTS " + PaisesContract.Fuso.TABLE_NAME;

    public static final String SQL_DROP_PAIS_FUSO =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisFuso.TABLE_NAME;

    // Contexto da aplicação, nome do banco, Cursor factory (resultSet), Versão do banco
    public PaisesDbHelper(Context contexto){
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("banco", "criou a tabela");
        db.execSQL(SQL_CREATE_PAIS);
        db.execSQL(SQL_CREATE_IDIOMA);
        db.execSQL(SQL_CREATE_DOMINIO);
        db.execSQL(SQL_CREATE_FRONTEIRA);
        db.execSQL(SQL_CREATE_FUSO);
        db.execSQL(SQL_CREATE_MOEDA);
        db.execSQL(SQL_CREATE_PAIS_DOMINIO);
        db.execSQL(SQL_CREATE_PAIS_FRONTEIRA);
        db.execSQL(SQL_CREATE_PAIS_FUSO);
        db.execSQL(SQL_CREATE_PAIS_IDIOMA);
        db.execSQL(SQL_CREATE_PAIS_MOEDA);
        Log.d("banco", "Pais_idioma");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("banco", "criou a tabela");
        db.execSQL(SQL_DROP_PAIS_IDIOMA);
        db.execSQL(SQL_DROP_PAIS_MOEDA);
        db.execSQL(SQL_DROP_PAIS_DOMINIO);
        db.execSQL(SQL_DROP_PAIS_FUSO);
        db.execSQL(SQL_DROP_PAIS_FRONTEIRA);
        db.execSQL(SQL_DROP_PAIS);
        db.execSQL(SQL_DROP_IDIOMA);
        db.execSQL(SQL_DROP_DOMINIO);
        db.execSQL(SQL_DROP_FRONTEIRA);
        db.execSQL(SQL_DROP_FUSO);
        db.execSQL(SQL_DROP_MOEDA);
        db.execSQL(SQL_CREATE_PAIS);
        db.execSQL(SQL_CREATE_IDIOMA);
        db.execSQL(SQL_CREATE_MOEDA);
        db.execSQL(SQL_CREATE_DOMINIO);
        db.execSQL(SQL_CREATE_FUSO);
        db.execSQL(SQL_CREATE_FRONTEIRA);
        db.execSQL(SQL_CREATE_PAIS_IDIOMA);
        db.execSQL(SQL_CREATE_PAIS_MOEDA);
        db.execSQL(SQL_CREATE_PAIS_DOMINIO);
        db.execSQL(SQL_CREATE_PAIS_FRONTEIRA);
        db.execSQL(SQL_CREATE_PAIS_FUSO);
    }
}
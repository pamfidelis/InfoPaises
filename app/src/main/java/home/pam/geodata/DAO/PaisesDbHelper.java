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


    public static final String SQL_DROP_PAIS =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisEntry.TABLE_NAME;

    public static final String SQL_DROP_IDIOMA =
            "DROP  TABLE IF EXISTS " + PaisesContract.Language.TABLE_NAME;

    public static final String SQL_DROP_PAIS_IDIOMA =
            "DROP  TABLE IF EXISTS " + PaisesContract.PaisLanguage.TABLE_NAME;

    // Contexto da aplicação, nome do banco, Cursor factory (resultSet), Versão do banco
    public PaisesDbHelper(Context contexto){
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("banco", "criou a tabela");
        db.execSQL(SQL_CREATE_PAIS);
        db.execSQL(SQL_CREATE_IDIOMA);
        db.execSQL(SQL_CREATE_PAIS_IDIOMA);
        Log.d("banco", "Pais_idioma");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d("banco", "criou a tabela");
        db.execSQL(SQL_DROP_PAIS_IDIOMA);
        db.execSQL(SQL_DROP_PAIS);
        db.execSQL(SQL_DROP_IDIOMA);
        db.execSQL(SQL_CREATE_PAIS);
        db.execSQL(SQL_CREATE_IDIOMA);
        db.execSQL(SQL_CREATE_PAIS_IDIOMA);
    }
}
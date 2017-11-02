package home.pam.geodata.DAO;

import android.provider.BaseColumns;

/**
 * Created by Pamela Fidelis on 16/10/2017.
 */

public class PaisesContract {

    // BaseColumns = id
    public static abstract class PaisEntry implements BaseColumns {
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_REGIAO = "regiao";
        public static final String COLUMN_NAME_SUBREGIAO = "subregiao";
        public static final String COLUMN_NAME_CAPITAL = "capital";
        public static final String COLUMN_NAME_BANDEIRA = "bandeira";
        public static final String COLUMN_NAME_CODIGO3 = "codigo3";
        public static final String COLUMN_NAME_DEMONIMO = "demonimo";
        public static final String COLUMN_NAME_AREA = "area";
        public static final String COLUMN_NAME_POPULACAO = "populacao";
        public static final String COLUMN_NAME_GINI = "gini";
        public static final String COLUMN_NAME_LATITUDE = "latitude";
        public static final String COLUMN_NAME_LONGITUDE = "longitude";
    }

    public static abstract class Language implements BaseColumns {
        public static final String TABLE_NAME = "idioma";
        public static final String COLUMN_NAME_IDIOMA= "nm_idioma";
    }

    public static abstract class PaisLanguage implements BaseColumns {
        public static final String TABLE_NAME = "pais_idioma";
        public static final String COLUMN_NAME_PAIS= "id_pais";
        public static final String COLUMN_NAME_IDIOMA= "id_idioma";
    }


}

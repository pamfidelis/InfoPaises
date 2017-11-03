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
        public static final String TABLE_NAME = "idioma_pais";
        public static final String COLUMN_NAME_PAIS= "id_pais";
        public static final String COLUMN_NAME_IDIOMA= "id_idioma";
    }

    public static abstract class  Moeda implements BaseColumns {
        public static final String TABLE_NAME = "moeda";
        public static final String COLUMN_NAME_MOEDA= "nm_moeda";
        public static final String COLUMN_NAME_CODE= "nm_code";
    }

    public static abstract class  PaisMoeda implements BaseColumns {
        public static final String TABLE_NAME = "moeda_pais";
        public static final String COLUMN_NAME_PAIS= "id_pais";
        public static final String COLUMN_NAME_MOEDA= "id_moeda";
    }

    public static abstract class  Dominio implements BaseColumns {
        public static final String TABLE_NAME = "dominio";
        public static final String COLUMN_NAME_DOMINIO= "nm_dominio";
    }

    public static abstract class  PaisDominio implements BaseColumns {
        public static final String TABLE_NAME = "dominio_pais";
        public static final String COLUMN_NAME_PAIS= "id_pais";
        public static final String COLUMN_NAME_DOMINIO= "id_dominio";
    }

    public static abstract class  Fuso implements BaseColumns {
        public static final String TABLE_NAME = "fuso";
        public static final String COLUMN_NAME_FUSO= "timeszones";
    }

    public static abstract class  PaisFuso implements BaseColumns {
        public static final String TABLE_NAME = "fuso_pais";
        public static final String COLUMN_NAME_PAIS= "id_pais";
        public static final String COLUMN_NAME_FUSO= "id_fuso";
    }

    public static abstract class  Fronteira implements BaseColumns {
        public static final String TABLE_NAME = "fronteira";
        public static final String COLUMN_NAME_FRONTEIRA= "nm_fronteira";
    }

    public static abstract class  PaisFronteira implements BaseColumns {
        public static final String TABLE_NAME = "fronteira_pais";
        public static final String COLUMN_NAME_PAIS= "id_pais";
        public static final String COLUMN_NAME_FRONTEIRA= "id_fronteira";
    }


}

package home.pam.geodata;

import android.provider.BaseColumns;

/**
 * Created by Pamela Fidelis on 16/10/2017.
 */

public class PaisesContract {

    // BaseColumns = id
    public static abstract class PaisEntry implements BaseColumns {
        public static final String TABLE_NAME = "pais";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_REGIAO = "regiao";
        public static final String COLUMN_CAPITAL = "capital";
        public static final String COLUMN_BANDEIRA = "bandeira";
        public static final String COLUMN_CODIGO3 = "codigo3";

    }
}

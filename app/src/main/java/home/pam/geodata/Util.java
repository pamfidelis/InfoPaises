package home.pam.geodata;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

/**
 * Created by Pamela Fidelis on 22/09/2017.
 */

public class Util {

    public static Drawable getDrawable(Context context, String nome){

        /* Reflexão */
        Class<?> c = R.drawable.class;
        try {
            /*Atributo da classe */
            Field idField = c.getDeclaredField(nome);
            try {
                int id = idField.getInt(idField);

                return context.getResources().getDrawable(id, null);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}

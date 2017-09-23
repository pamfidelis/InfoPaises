package home.pam.geodata;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;
import java.util.TreeSet;

/**
 * Created by Pamela Fidelis on 22/09/2017.
 */

public class SectionIndexBuilder {

    //Cria um array de cabeçalhos de seção, dados devem estar ordenadors por nome

    public static Object[] builderSectionHeaders(Pais[] paises){

        ArrayList<String> resultado = new ArrayList<>();

        // Ordena (tree) e impede que elementos se repetem (set)
        TreeSet<String> usados = new TreeSet<>();

        for(Pais pais : paises){
            String letra = pais.getNome().substring(0,1);
            if (!usados.contains(letra)){
                resultado.add(letra);
            }
            usados.add(letra);
        }
        return resultado.toArray(new Object[0]);
    }


    // cria um mapa para responder posição ---> seção dedados ordenados pelo nome
    public static Hashtable<Integer, Integer> builderSectionPositionMap(Pais [] paises){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();

        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < paises.length; i++){
            String letra = paises[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
            }
            resultados.put(i, secao);
        }
        return resultados;
    }

    // cria um mapa para responder posição ---> seção dedados ordenados pelo nome
    public static Hashtable<Integer, Integer> builderPositionSectionMap(Pais [] paises){
        Hashtable<Integer, Integer> resultados = new Hashtable<>();

        TreeSet<String> usados = new TreeSet<>();

        int secao = -1;

        for(int i = 0; i < paises.length; i++){
            String letra = paises[i].getNome().substring(0,1);

            if(!usados.contains(letra)){
                secao++;
                usados.add(letra);
                resultados.put(secao, i);
            }
        }
        return resultados;
    }
}

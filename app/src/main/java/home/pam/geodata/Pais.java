package home.pam.geodata;

import java.util.ArrayList;

/**
 * Created by Pamela on 10/09/2017.
 */

public class Pais {

    public static ArrayList<String> getPaises(){
        ArrayList<String> paises = new ArrayList<>();

        paises.add("Brasil");
        paises.add("Argentina");
        paises.add("EUA");
        paises.add("Japão");
        paises.add("Egito");
        paises.add("Espanha");
        paises.add("Venezuela");
        paises.add("Ingleterra");
        paises.add("Alemanha");
        paises.add("Itália");
        paises.add("Costa Rica");
        paises.add("Luxemburgo");
        paises.add("Peru");
        paises.add("Suíça");
        paises.add("Holanda");

        return paises;
    }

    public static ArrayList<String> buscarPais (String chave){
        if(chave.equals("")){
            return getPaises();
        }else {
            ArrayList<String> lista_pais = new ArrayList<>();

            for (String nome : getPaises()) {
                if (nome.toLowerCase().startsWith(chave.toLowerCase())) {
                    lista_pais.add(nome);
                }
            }

            if(lista_pais.size() != 0){
                return lista_pais;
            }else{
                return getPaises();
            }
        }
    }
}

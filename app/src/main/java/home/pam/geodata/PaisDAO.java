package home.pam.geodata;

import java.util.ArrayList;

/**
 * Created by Pamela on 13/09/2017.
 */

public class PaisDAO {

     ArrayList<Pais> paises = new ArrayList<>();

    public PaisDAO() {
    }

    public ArrayList<Pais> criarPais(){

        Pais brasil = new Pais();

        ArrayList<String> br_idiomas = new ArrayList<>();
        br_idiomas.add("portugues");

        ArrayList<String> br_moedas = new ArrayList<>();
        br_moedas.add("real");

        ArrayList<String> br_dominios = new ArrayList<>();

        ArrayList<String> br_fusos = new ArrayList<>();
        br_fusos.add("UTC-05:00");
        br_fusos.add("UTC-04:00");
        br_fusos.add("UTC-03:00");
        br_fusos.add("UTC-02:00");

        ArrayList<String> br_fronteiras = new ArrayList<>();
        br_fronteiras.add("ARG");
        br_fronteiras.add("BOL");
        br_fronteiras.add("COL");
        br_fronteiras.add("GUF");
        br_fronteiras.add("GUY");
        br_fronteiras.add("PRY");
        br_fronteiras.add("PER");
        br_fronteiras.add("SUR");
        br_fronteiras.add("URY");
        br_fronteiras.add("VEN");

        brasil.setNome("Brasil");
        brasil.setCodigo3("BR");
        brasil.setCapital("Brasilia");
        brasil.setRegiao("America");
        brasil.setSubRegiao("América do Sul");
        brasil.setDemonimo("Brasileiro");
        brasil.setPopulacao(206135893);
        brasil.setArea(8515767);
        brasil.setBandeira("https://restcountries.eu/data/bra.svg");
        brasil.setGini(54.7);
        brasil.setIdiomas(br_idiomas);
        brasil.setMoedas(br_moedas);
        brasil.setDominios(br_dominios);
        brasil.setFusos(br_fusos);
        brasil.setFronteiras(br_fronteiras);
        brasil.setLatitude(-10);
        brasil.setLongitude(-55);

        /* -------------------------------------------------------------------------------------- */

        Pais franca = new Pais();

        franca.setNome("França");
        franca.setCodigo3("FR");
        franca.setCapital("Paris");
        franca.setRegiao("Europa");
        franca.setSubRegiao("Europa Ocidental");
        franca.setDemonimo("franceses");
        franca.setPopulacao(66710000);
        franca.setArea(640679);
        franca.setBandeira("https://restcountries.eu/data/fra.svg");
        franca.setGini(32.7);


         /*Idiomas*/
        ArrayList<String> fr_idiomas = new ArrayList<>();
        fr_idiomas.add("frances");

        franca.setIdiomas(fr_idiomas);

        /*Moedas*/
        ArrayList<String> fr_moedas = new ArrayList<>();
        fr_moedas.add("real");

        franca.setMoedas(fr_moedas);

        /*Dominios*/
        ArrayList<String> fr_dominios = new ArrayList<>();

        franca.setDominios(fr_dominios);

        /*Fuso Horário*/
        ArrayList<String> fr_fusos = new ArrayList<>();

        franca.setFusos(fr_fusos);

        /*Fronteiras */
        ArrayList<String> fr_fronteiras = new ArrayList<>();

        franca.setFronteiras(fr_fronteiras);

        franca.setLatitude(46);
        franca.setLongitude(2);
    /* -------------------------------------------------------------------------------------- */


        return paises;
    }

}

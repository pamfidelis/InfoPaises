package home.pam.geodata;

import java.util.ArrayList;

/**
 * Created by Pamela on 10/09/2017.
 */

public class Pais {

    private String nome;
    private String codigo3;
    private String capital;
    private String regiao;
    private String subRegiao;
    private String demonimo;
    private int populacao;
    private int area;
    private String bandeira;
    double gini;
    private ArrayList<String> idiomas;
    private ArrayList<String> moedas;
    private ArrayList<String> dominios;
    private ArrayList<String> fusos;
    private ArrayList<String> fronteiras;
    private double latitude;
    private double longitude;

    public Pais() {
    }

    public Pais(String nome, String codigo3, String capital, String regiao, String subRegiao, String demonimo,
                    int populacao, int area, String bandeira, double gini, ArrayList<String> idiomas,
                    ArrayList<String> moedas, ArrayList<String> dominios, ArrayList<String> fusos,
                    ArrayList<String> fronteiras, double latitude, double longitude) {
        this.nome = nome;
        this.codigo3 = codigo3;
        this.capital = capital;
        this.regiao = regiao;
        this.subRegiao = subRegiao;
        this.demonimo = demonimo;
        this.populacao = populacao;
        this.area = area;
        this.bandeira = bandeira;
        this.gini = gini;
        this.idiomas = idiomas;
        this.moedas = moedas;
        this.dominios = dominios;
        this.fusos = fusos;
        this.fronteiras = fronteiras;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo3() {
        return codigo3;
    }

    public void setCodigo3(String codigo3) {
        this.codigo3 = codigo3;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegiao() {
        return regiao;
    }

    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }

    public String getSubRegiao() {
        return subRegiao;
    }

    public void setSubRegiao(String subRegiao) {
        this.subRegiao = subRegiao;
    }

    public String getDemonimo() {
        return demonimo;
    }

    public void setDemonimo(String demonimo) {
        this.demonimo = demonimo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public double getGini() {
        return gini;
    }

    public void setGini(double gini) {
        this.gini = gini;
    }

    public ArrayList<String> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(ArrayList<String> idiomas) {
        this.idiomas = idiomas;
    }

    public ArrayList<String> getMoedas() {
        return moedas;
    }

    public void setMoedas(ArrayList<String> moedas) {
        this.moedas = moedas;
    }

    public ArrayList<String> getDominios() {
        return dominios;
    }

    public void setDominios(ArrayList<String> dominios) {
        this.dominios = dominios;
    }

    public ArrayList<String> getFusos() {
        return fusos;
    }

    public void setFusos(ArrayList<String> fusos) {
        this.fusos = fusos;
    }

    public ArrayList<String> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(ArrayList<String> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", codigo3='" + codigo3 + '\'' +
                ", capital='" + capital + '\'' +
                ", regiao='" + regiao + '\'' +
                ", subRegiao='" + subRegiao + '\'' +
                ", demonimo='" + demonimo + '\'' +
                ", populacao=" + populacao +
                ", area=" + area +
                ", bandeira='" + bandeira + '\'' +
                ", gini=" + gini +
                ", idiomas=" + idiomas +
                ", moedas=" + moedas +
                ", dominios=" + dominios +
                ", fusos=" + fusos +
                ", fronteiras=" + fronteiras +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

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

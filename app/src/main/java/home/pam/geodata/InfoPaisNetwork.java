package home.pam.geodata;

import android.content.Context;
import android.net.ConnectivityManager;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Pâmela Fidelis on 06/10/17.
 */

public class InfoPaisNetwork {
    public static Pais[] buscarPaises(String url, String regiao) throws IOException {
        OkHttpClient client = new OkHttpClient();
        ArrayList<Pais> paises = new ArrayList<>();

        Request request = new Request.Builder()
                .url(url+regiao)
                .build();

        Response response = client.newCall(request).execute();

        String resultado = response.body().string();

        try {
            JSONArray vetor = new JSONArray(resultado);
            for(int i = 0; i < vetor.length(); i++){
                JSONObject item = (JSONObject) vetor.get(i);
                Pais pais = new Pais();

                pais.setBandeira(item.getString("flag"));
                pais.setNome(item.getString("name"));
                pais.setCapital(item.getString("capital"));
                pais.setRegiao(item.getString("region"));
                pais.setSubRegiao(item.getString("subregion"));
                pais.setCodigo3(item.getString("alpha3Code"));
                pais.setDemonimo(item.getString("demonym"));
                pais.setSubRegiao(item.getString("subregion"));

                try {
                    pais.setArea(item.getInt("area"));
                } catch (Exception e){
                    pais.setArea(0);
                }

                try {
                    pais.setPopulacao(item.getInt("population"));
                } catch (Exception e) {
                    pais.setPopulacao(0);
                }

                try {
                    pais.setGini(item.getDouble("gini"));

                    Log.d("gini", "" + pais.getGini());

                } catch (Exception e) {
                    pais.setGini(0.0);
                }

                JSONArray latlng = item.getJSONArray("latlng");
                try {
                    pais.setLatitude(latlng.getDouble(0));
                } catch (Exception e) {
                    pais.setLatitude(0);
                }
                try {
                    pais.setLongitude(latlng.getDouble(1));
                } catch (Exception e) {
                    pais.setLongitude(0);
                }

                ArrayList<String> arrayList = new ArrayList<String>();
                JSONObject jsonObject;

                JSONArray jArray = item.getJSONArray("languages");

                for (int x = 0; x < jArray.length(); x++){
                    jsonObject = jArray.getJSONObject(x);
                    arrayList.add((String)jsonObject.opt("name"));
                }
                pais.setIdiomas(arrayList);

               jArray = item.getJSONArray("timezones");
               arrayList = new ArrayList<>();

               for (int x = 0; x < jArray.length(); x++) {
                    arrayList.add((String)jArray.get(x));
                }
                pais.setFusos(arrayList);

                jArray = item.getJSONArray("topLevelDomain");
                arrayList = new ArrayList<>();

                for (int x = 0; x < jArray.length(); x++) {
                    arrayList.add((String)jArray.get(x));
                }
                pais.setDominios(arrayList);

                jArray = item.getJSONArray("currencies");
                arrayList = new ArrayList<>();

                for (int x = 0; x < jArray.length(); x++) {
                    jsonObject = jArray.getJSONObject(x);

                    for (int y = 0; y < jsonObject.length(); y++) {
                        arrayList.add(jsonObject.getString("code"));
                        arrayList.add(jsonObject.getString("name"));
                        arrayList.add(jsonObject.getString("symbol"));
                    }
                }
                pais.setMoedas(arrayList);

                jArray = item.getJSONArray("borders");
                arrayList = new ArrayList<>();

                for (int x = 0; x < jArray.length(); x++) {
                    arrayList.add((String)jArray.get(x));
                }
                pais.setFronteiras(arrayList);

                paises.add(pais);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new IOException(e);
        }

        return paises.toArray(new Pais[0]);
    }

    public static boolean isConnected(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null &&
                connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
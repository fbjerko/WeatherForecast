import org.w3c.dom.*;
import org.xml.sax.SAXException;

import org.json.JSONObject;
import org.json.XML;

import java.net.*;
import java.io.*;
import org.json.*;

import javax.xml.parsers.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class XMLReader {
    public static void main(String[] args){
        ArrayList<String> timeStampArray = new ArrayList<>();
        ArrayList<String> forecastSymbolArray = new ArrayList<>();
        try {
            JSONArray jsonArray =  jsonArrayMaker("https://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10&lon=9.58");
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject object0 = jsonArray.getJSONObject(i);
                for(int j = 0; j < object0.length(); j++ ){
                    JSONObject object1 = jsonArray.getJSONObject(j);
                    //Get time:
                    String from = object1.getString("from");
                    String to = object1.getString("to");
                    String fromTo = from + to;
                    System.out.println(from +to);
                    timeStampArray.add(fromTo);

                    //Get forecast:
                    String forecastSymbol = object1.getString("symbol");
                    forecastSymbolArray.add(forecastSymbol);

                    System.out.println(from+to + " " + forecastSymbol);
                }
            }
        }catch (JSONException e){

        }

    }

    public static JSONArray jsonArrayMaker(String url){
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        JSONObject object;
        JSONArray jsonArray = null;
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = buffer.readLine()) != null) {
                stringBuilder.append(line);
            }
            object = XML.toJSONObject(stringBuilder.toString()).getJSONObject("weatherdata").getJSONObject("product");
            jsonArray = object.getJSONArray("time");

        }catch (IOException e){
            System.out.println(e);
        }catch (JSONException e){
            System.out.println(e);
        }
        return jsonArray;
    }

}

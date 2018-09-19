
import java.net.*;
import java.io.*;
import java.util.Scanner;

import org.json.*;





public class Map {

    public static void main(String[] args) {
        NewClass a = new NewClass();

        a.getChar();

        getWeather();
    }

    public static void getWeather() {
        System.out.println("It's very VEEEERY great");
    }

   /* JSONObject jobj;
    public JSONObject getChar() {
        try {
            //Open character
            URLConnection connection = new URL("https://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10&lon=9.58").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                stringBuilder.append(line);


            }
            jobj = XML.toJSONObject(stringBuilder.toString());
            System.out.println(jobj.toString());
            return jobj;

        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (JSONException e) {
            System.out.println(e.toString());
        }
        return jobj;

    }*/

}



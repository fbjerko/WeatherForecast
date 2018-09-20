import org.json.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class GetWeatherInfo {

    static JSONObject today, tomorrow, response;




    static String oslo = "lat=59.91&lon=10.75";
    static String bergen = "lat=60.39&lon=05.32";
    static String trondheim = "lat=63.43&lon=10.39";
    static String stavanger = "lat=58.97&lon=05.73";
    static String kristiansand = "lat=58.15&lon=08.01";
    static String tromsø = "lat=69.64&lon=18.95";


    public static void main(String[] args) {

    makeObject();

    }

    public static JSONObject makeObject(){

        try{

            StringBuilder stringBuilder1 = new StringBuilder();
            stringBuilder1.append("{cities: [ " +
                                "{city: oslo," + getXML(oslo)+ "},");

            stringBuilder1.append("{city: bergen," + getXML(bergen)+ "},");
            stringBuilder1.append("{city: trondheim, " + getXML(trondheim)+ "},");
            stringBuilder1.append("{city: stavanger," + getXML(stavanger)+ "},");
            stringBuilder1.append("{city: kristiansang," + getXML(kristiansand)+ "},");
            stringBuilder1.append("{city: tromsø, " + getXML(tromsø)+ "}]}");


            System.out.println(stringBuilder1.toString());
        response = new JSONObject(stringBuilder1.toString());

            System.out.println(response);


       // System.out.println(response);

        return response;

        } catch (JSONException e){
            System.out.println(e.toString());
        }
        return response;
    }

    public static String getXML(String longLat){

        String timeToday = "";
        String symbolToday = "";

        String timeNextDay = "";
        String symbolNextDay = "";
        try {
            URLConnection connection = new URL("https://api.met.no/weatherapi/locationforecast/1.9/?" + longLat).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            StringBuilder stringBuilder1 = new StringBuilder();
            String line;

            while ((line = buffer.readLine()) != null) {
                stringBuilder1.append(line + "\n");
            }
      
            today = XML.toJSONObject(stringBuilder1.toString());
            today = today.getJSONObject("weatherdata").getJSONObject("product"); // om 24 timer

            for(int i = 0; i <260 ; i++) {
                if(i % 5 == 0) {

                    continue;
                }
                char a = today.getJSONArray("time").getJSONObject(i).getString("to").charAt(11);
                char b = today.getJSONArray("time").getJSONObject(i).getString("to").charAt(12);
                char c = today.getJSONArray("time").getJSONObject(i).getString("from").charAt(12);

                if (a == '1' && b == '2') {

                    if(b == c) {
                        continue;
                    }


                    timeToday = today.getJSONArray("time").getJSONObject(i).getString("to");
                    symbolToday = today.getJSONArray("time").getJSONObject(i).getJSONObject("location").getJSONObject("symbol").getString("id");

                    System.out.println("Weather:" + symbolToday);

                    i += 120;
                }

                if (a == '1' && b == '2') {

                    timeNextDay = today.getJSONArray("time").getJSONObject(i).getString("to");
                    symbolNextDay = today.getJSONArray("time").getJSONObject(i).getJSONObject("location").getJSONObject("symbol").getString("id");

                    System.out.println("Weather:" + symbolNextDay);
                    System.out.println();
                    break;
                }
            }
            return "today: " + symbolToday + ", tomorrow:"  + symbolNextDay ;

        } catch(IOException e){
            System.out.println(e.toString());
        } catch(JSONException e){
            System.out.println(e.toString());
        }

        return "No data";

    }
}

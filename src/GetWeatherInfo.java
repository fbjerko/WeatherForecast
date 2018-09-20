import org.json.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class GetWeatherInfo {

    static JSONObject today, tomorrow;

    public static void main(String[] args) {



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

            StringBuilder stringBuilder2 = new StringBuilder();
            String line;

            while ((line = buffer.readLine()) != null) {
                stringBuilder2.append(line + "\n");
            }
      
            today = XML.toJSONObject(stringBuilder2.toString());
            today = today.getJSONObject("weatherdata").getJSONObject("product"); // om 24 timer

            for(int i = 0; i <260 ; i++) {
                if(i % 5 == 0) {
                    continue;
                }
                char a = today.getJSONArray("time").getJSONObject(i).getString("to").charAt(11);
                char b = today.getJSONArray("time").getJSONObject(i).getString("to").charAt(12);

                if (a == '1' && b == '2') {

                    timeToday = today.getJSONArray("time").getJSONObject(i).getString("to");
                    symbolToday = today.getJSONArray("time").getJSONObject(i).getJSONObject("location").getJSONObject("symbol").getString("id");
                    System.out.println("Today : " + timeToday);
                    System.out.println("Weather : " + symbolToday);

                    i += 120;
                }

                if (a == '1' && b == '2') {

                    timeNextDay = today.getJSONArray("time").getJSONObject(i).getString("to");
                    symbolNextDay = today.getJSONArray("time").getJSONObject(i).getJSONObject("location").getJSONObject("symbol").getString("id");
                    System.out.println("Tomorrow : " + timeNextDay);
                    System.out.println("Weather : " + symbolNextDay);
                    System.out.println();
                    break;
                }
            }
            return timeToday + "\n" + symbolToday + "\n" + timeNextDay + "\n" + symbolNextDay;

        } catch(IOException e){
            System.out.println(e.toString());
        } catch(JSONException e){
            System.out.println(e.toString());
        }

        return "No data";

    }
}

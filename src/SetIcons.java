import org.json.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class SetIcons {

   static String oslo = "lat=59.91&lon=10.75";
   static String bergen = "lat=60.39&lon=05.32";
   static String trondheim = "lat=63.43&lon=10.39";
   static String stavanger = "lat=58.97&lon=05.73";
   static String kristiansand = "lat=58.15&lon=08.01";
   static String tromsø = "lat=69.64&lon=18.95";

    static JSONObject today, tomorrow;

    public static void main(String[] args) {

        getXML(oslo);
        getXML(bergen);
        getXML(trondheim);
        getXML(stavanger);
        getXML(kristiansand);
        getXML(tromsø);
    }

    public static void getXML(String longlat){

        String timeToday;
        String symbolToday;

        String timeNextDay;
        String symbolNextDay;
        try {
            URLConnection connection = new URL("https://api.met.no/weatherapi/locationforecast/1.9/?" + longlat).openConnection();
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

                    timeToday = today.getJSONArray("time").getJSONObject(i).getString("to");
                    symbolToday = today.getJSONArray("time").getJSONObject(i).getJSONObject("location").getJSONObject("symbol").getString("id");
                    System.out.println("Tomorrow : " + timeToday);
                    System.out.println("Weather : " + symbolToday);
                    System.out.println();
                    break;
                }
            }
        } catch(IOException e){
            System.out.println(e.toString());
        } catch(JSONException e){
            System.out.println(e.toString());
        }
    }
}

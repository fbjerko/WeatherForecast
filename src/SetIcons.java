import org.json.*;
import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class SetIcons {


    /* Her må vi få sende get request til vær-api for å avgjøre
    vær-ikon for byene i norge vi skal displaye

    Typ:
    - Oslo
    - Bergen
    - Trondheim
    - Stavanger
    - Tromsø
    - Skedsmokorset **VIKTIG**
    - Re kommune    **VIKTIG*


    DisplayMap kaller på metoder herfra
     */
    // lat=60.10&lon=9.58
   static String oslo = "lat=59.91&lon=10.75";
   static String bergen = "lat=60.39&lon=05.32";
   static String trondheim = "lat=63.43&lon=10.39";
   static String stavanger = "lat=58.97&lon=05.73";
   static String kristiansand = "lat=58.15&lon=08.01";
   static String tromsø = "lat=69.64&lon=18.95";

    static JSONObject today, tomorrow;
    static ArrayList<String> info;


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

            info = new ArrayList<>();

            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();
            String line;



            while ((line = buffer.readLine()) != null) {
                info.add(line);
                stringBuilder2.append(line + "\n");
            }

            for(int i = 0; i<6; i++) {
                stringBuilder.append(info.get(25+i) + "\n");
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



           // System.out.println(today.getString("from") + " to " + tomorrow.getString("to"));
           // System.out.println(tomorrow.getJSONObject("location").getJSONObject("symbol").getString("id"));


            //System.out.println(object.getJSONObject("location").getJSONObject("symbol").getString("id"));
            //System.out.println(object.getJSONObject("weatherdata").getJSONObject("product").getJSONArray("time"));


            //System.out.println(object.getJSONArray("weatherdata"));
           // System.out.println("1");
           // System.out.println(object.getString("weatherdata"));
           // System.out.println(object.getJSONArray("time").get);


        } catch(IOException e){
            System.out.println(e.toString());
        } catch(JSONException e){
            System.out.println(e.toString());
        }

    }


    //Metoder


}

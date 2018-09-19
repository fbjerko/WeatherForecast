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

    String Oslo = "";
    String Bergen = "";
    String Trondheim = "";
    String Stavanger = "";
    String Kristiansand = "";
    String Tromsø = "";

    static JSONObject today, tomorrow;
    static ArrayList<String> info;


    public static void main(String[] args) {
        getXML();
    }


    public static void getXML(){

        String timeToday;
        String symbolToday;

        String timeNextDay;
        String symbolNextDay;
        try {
            URLConnection connection = new URL("https://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10&lon=9.58&msl=70").openConnection();
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

            //System.out.println(stringBuilder2.toString());
            //System.out.println(stringBuilder2.toString());

            //System.out.println(stringBuilder.toString());
           // object = new JSONArray(stringBuilder.toString());

            tomorrow = today = XML.toJSONObject(stringBuilder2.toString());

           // today = today.getJSONObject("weatherdata").getJSONObject("product").getJSONArray("time").getJSONObject(6); // om 24 timer

            //tomorrow = tomorrow.getJSONObject("weatherdata").getJSONObject("product").getJSONArray("time").getJSONObject(130); // om 24 timer

            today = today.getJSONObject("weatherdata").getJSONObject("product"); // om 24 timer

            tomorrow = tomorrow.getJSONObject("weatherdata").getJSONObject("product"); // om 24 timer


          //  System.out.println(today.getString("from") + " to " + today.getString("to"));
           // System.out.println(today.getJSONObject("location").getJSONObject("symbol").getString("id"));

            System.out.println();


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

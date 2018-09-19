import org.json.*;
import java.net.*;
import java.io.*;

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

    static JSONArray object;


    public static void main(String[] args) {
        getXML();
    }


    public static void getXML(){
        try {
            URLConnection connection = new URL("https://api.met.no/weatherapi/locationforecast/1.9/?lat=60.10&lon=9.58&msl=70").openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

           // object = new JSONArray(stringBuilder.toString());


            System.out.println(stringBuilder.toString());


        } catch(IOException e){
            System.out.println(e.toString());
        }

    }


    //Metoder


}

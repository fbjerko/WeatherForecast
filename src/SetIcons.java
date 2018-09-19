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

    JSONObject object;


    public static void main(String[] args) {
        //Bruker denne til testing
    }


    public JSONObject getCharacter(int id){
        try {
            URLConnection connection = new URL("https://anapioficeandfire.com/api/characters/" + id).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();

            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));


            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = buffer.readLine()) != null) {
                stringBuilder.append(line);
            }

            object = new JSONObject(stringBuilder.toString());
            System.out.println("</br>Name: "+ object.getString("name") + "</br>Gender: " + object.getString("gender")
                    + "</br>Born: " + object.getString("born") + "</br>Main alias: " + object.getJSONArray("aliases").getString(0) + "</br>Played by: " + object.getJSONArray("playedBy").getString(0));


        } catch(IOException e){
            System.out.println(e.toString());
        } catch(JSONException e){
            System.out.println(e.toString());
        }

        return object;
    }


    //Metoder


}

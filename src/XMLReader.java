import org.json.JSONObject;
import org.json.XML;
import java.io.*;
import org.json.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class XMLReader {

    public static ArrayList<String> getForecast(String coordinates){
        //Returns an arraylist of the weather forecast for the given day plus the next if called before 12PM.
        // (The coming hour of the given day and the first hour of the next day)
        //Only the forecast for the first hour of the next day will be returned if called after 12:00pm.

        ArrayList<String> forecastArray = new ArrayList<>();
        ArrayList<String> timeStampArray = new ArrayList<>();
        ArrayList<String> forecastSymbolArray = new ArrayList<>();

        try {
            JSONObject jsonObject =  jsonObjectMaker("https://api.met.no/weatherapi/locationforecast/1.9/?" + coordinates);
            JSONArray timeArray = jsonObject.getJSONArray("time");
            for(int i = 0; i < timeArray.length(); i++){
                JSONObject timeObject = timeArray.getJSONObject(i);
                String from = timeObject.getString("from");
                String to = timeObject.getString("to");
                String timeStamp = from+to;

                //System.out.println(timeArray.getJSONObject(i));
                for(int j = 0; j < timeObject.length(); j++ ){
                    JSONObject locationObject =  timeObject.getJSONObject("location");
                    if(locationObject.has("symbol")){

                        //Store timestamp:
                        timeStampArray.add(timeStamp);
                        JSONObject symbolObject = locationObject.getJSONObject("symbol");

                        //Store forecast symbol
                        String forecast = symbolObject.getString("id");
                        forecastSymbolArray.add(forecast);
                    }
                }
            }

            DateFormat timeAndDate = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            String dateString = timeAndDate.format(date);

            String today = dateString.split("-")[2];
            int todayInt = Integer.parseInt(today);
            int forecastIndex = 0;

            //If it has passed mid day
            if (cal.get(Calendar.HOUR_OF_DAY) >= 12) {
                for(int i = 0; i < timeStampArray.size(); i++){
                    String[] dateAndTime = timeStampArray.get(i).split("T");
                    String[] day = dateAndTime[0].split("-");
                    int dayInt = Integer.parseInt(day[2]);

                    //Fetch forecast for the next day and add it to the array of forecasts
                    if(dayInt == (todayInt + 1) ) {
                        forecastIndex = i;
                        forecastArray.add(forecastSymbolArray.get(i));
                        break;
                    }
                }
            }else{
                for(int i = 0; i < timeStampArray.size(); i++){
                    String[] dateAndTime = timeStampArray.get(i).split("T");
                    String[] day = dateAndTime[0].split("-");
                    int dayInt = Integer.parseInt(day[2]);

                    //Fetch forecast for the today and add it to the array of forecasts
                    if(dayInt == todayInt ) {
                        forecastArray.add(forecastSymbolArray.get(i));
                    }

                    //Fetch forecast for the next day and add it to the array of forecasts
                    if(dayInt == (todayInt + 1) ) {
                        forecastArray.add(forecastSymbolArray.get(i));
                    }
                }
            }
        }catch (JSONException e){
            System.out.println(e.toString());
        }
        return forecastArray;
    }

    public static JSONObject jsonObjectMaker(String url){
        //Returns JSONObject containing time-objects.
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        JSONObject object = null;
        try {
            URLConnection connection = new URL(url).openConnection();
            connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            connection.connect();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = buffer.readLine()) != null) {
                stringBuilder.append(line);
            }
            object = XML.toJSONObject(stringBuilder.toString()).getJSONObject("weatherdata").getJSONObject("product");

        }catch (IOException e){
            System.out.println(e);
        }catch (JSONException e){
            System.out.println(e);
        }
        return object;
    }

}

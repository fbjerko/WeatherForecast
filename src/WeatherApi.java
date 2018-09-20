import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.servlet.http.*;

public class WeatherApi extends HttpServlet {

    PrintWriter out;

    XMLReader xmlReader = new XMLReader();

    GetWeatherInfo getIcon = new GetWeatherInfo();

    static String oslo = "lat=59.91&lon=10.75";
    static String bergen = "lat=60.39&lon=05.32";
    static String trondheim = "lat=63.43&lon=10.39";
    static String stavanger = "lat=58.97&lon=05.73";
    static String kristiansand = "lat=58.15&lon=08.01";
    static String tromsø = "lat=69.64&lon=18.95";

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Set the response MIME type of the response message
        response.setContentType("text/html");
        // Allocate a output writer to write the response message into the network socket
        out = response.getWriter();

        String _oslo =  xmlReader.getForecast(oslo);
        String _bergen =  getIcon.getXML(bergen);
        String _trondheim =  getIcon.getXML(trondheim);
        String _stavanger =  getIcon.getXML(stavanger);
        String _kristiansand =  getIcon.getXML(kristiansand);
        String _tromsø =  getIcon.getXML(tromsø);



        // Write the response message, in an HTML page
        try {
            out.println("<html>\n<head>\n\t<title>Norway Weather Forecast</title>\n</head>\n<body style=\"background-color:lightblue\">");
            out.println("<p>Oslo: "+ _oslo + "</p>");
            out.println("<p>Bergen: "+ _bergen + "</p>");
            out.println("<p>Trondheim: "+ _trondheim + "</p>");
            out.println("<p>Stavanger: "+ _stavanger + "</p>");
            out.println("<p>Kristiansand: "+ _kristiansand + "</p>");
            out.println("<p>Tromsø: "+ _tromsø + "</p>");

            out.println("</body>\n</html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }

}


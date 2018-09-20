import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.servlet.http.*;

public class WeatherApi extends HttpServlet {

    PrintWriter out;

    XMLReader xmlReader = new XMLReader();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Set the response MIME type of the response message
        response.setContentType("text/html");
        // Allocate a output writer to write the response message into the network socket
        out = response.getWriter();

        GetWeatherInfo apiResponse = new GetWeatherInfo();



        // Write the response message, in an HTML page
        try {
           // out.println("<html>\n<head>\n\t<title>Norway Weather Forecast</title>\n</head>\n<body style=\"background-color:lightblue\">");
            out.println(apiResponse.makeObject());

            //out.println("</body>\n</html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }

}


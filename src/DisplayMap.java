import java.io.*;
import java.net.*;
import javax.servlet.http.*;

public class DisplayMap extends HttpServlet {

    PrintWriter out;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        // Set the response MIME type of the response message
        response.setContentType("text/html");
        // Allocate a output writer to write the response message into the network socket
        out = response.getWriter();

        // Write the response message, in an HTML page
        try {
            out.println("<html>\n<head>\n\t<title>Norway Weather Forecast</title>\n</head>\n<body style=\"background-color:lightblue\">");
            out.println("<h1></h1>");
            out.println("<div><iframe\n" +
                    "  width=\"1000\"\n" +
                    "  height=\"1000\"\n" +
                    "  align=\"center\"\n" +
                    "  frameborder=\"0\" style=\"border:0\"\n" +
                    "  src=\"https://www.google.com/maps/embed/v1/place?key=AIzaSyA8KFuvfGGARrSNVZVsnsePgUws7jnzBK4\n" +
                    "    &q=Norway\" allowfullscreen>\n" +
                    "</iframe><div>");
            out.println("</body>\n</html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }

}


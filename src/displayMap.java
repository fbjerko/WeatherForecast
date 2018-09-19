import java.io.*;
import java.net.*;
import javax.servlet.http.*;

public class displayMap extends HttpServlet {

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
            out.println("<html>\n<head>\n\t<title>Norway Weather Forecast</title>\n</head>\n<body>");
            out.println("<h1>HeyHeyHey Weather </h1>");
            out.println("</body>\n</html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }

}

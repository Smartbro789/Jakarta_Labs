package labs.labs;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String header, objective;


    public void init() {
        header = "3A Capital";
        objective ="Creating a website for booking tickets at a cinema.";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<head>");
        out.println("<title>3A&M Capital</title>");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1 align='center'>" + header + "</h1>");
        out.println("<h2>");
        out.println("<p>Objective:" + objective + "</p>");
        out.println("<p>Use Cases:</p>");
        out.println("<ul>");
        out.println("<li>Aministrator</li>");
        out.println("<ul>");
        out.println("<li>Creation/editing/deletion of information about sessions and tickets.</li>");
        out.println("</ul>");
        out.println("<li>Guest</li>");
        out.println("<ul>");
        out.println("<li>Viewing sessions</li>");
        out.println("<li>Ordering tickets</li>");
        out.println("</ul>");
        out.println("</ul>");
        out.println("</h2>");
        out.println("</body>");
        out.println("</html>");
    }

    public void destroy() {
    }
}
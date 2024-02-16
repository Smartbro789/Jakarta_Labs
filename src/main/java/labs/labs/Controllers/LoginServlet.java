package labs.labs.Controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve parameters from the login form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Check if username and password match
        if (username != null && password != null && username.equals("admin") && password.equals("admin")) {
            // If credentials are valid, redirect to success page
            response.sendRedirect("Views/adminLoginSuccess.jsp");
        } else {
            // If credentials are invalid, redirect back to login page
            response.sendRedirect("login.jsp");
        }
    }
}
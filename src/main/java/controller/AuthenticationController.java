package controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import model.Cinema;
import model.User;

public class AuthenticationController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request) {
        String action = request.getParameter("action");

        switch (action) {
            case "login":
                return login(request);
            case "logout":
                return logout(request);
            case "register":
                return register(request);
            default:
                return null; // Handle invalid action
        }
    }

    private String login(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        Cinema cinema = Cinema.getCinema();
        User user = cinema.getUserByName(name);
        String resultPage = (user != null && user.getPassword().equals(password)) ? "controller?action=main" : "login.jsp";

        if (user == null) {
            request.setAttribute("notExists", "User does not exist");
        } else if (user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("system", cinema);
        } else {
            request.setAttribute("notExists", "Incorrect password");
        }

        return resultPage;
    }

    private String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "controller?action=main";
    }

    private String register(HttpServletRequest request) {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = new User(name, password);

        Cinema cinema = Cinema.getCinema();
        boolean add = cinema.addUser(user);

        if (add) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("system", cinema);
            return "controller?action=main";
        } else {
            request.setAttribute("notAdd", "This user already exists");
            return "register.jsp";
        }
    }
}

package controller;

import jakarta.servlet.http.HttpServletRequest;

import model.Cinema;
import model.Seance;
import model.User;

public class SeanceController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request) {
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                return createSeance(request);
            case "delete":
                return deleteSeance(request);
            case "edit":
                return editSeance(request);
            case "get":
                return getSeance(request);
            default:
                return null; // Handle invalid action
        }
    }

    private String createSeance(HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        String header = request.getParameter("header");
        int numberOfPlaces = Integer.parseInt(request.getParameter("num"));

        Seance seance = new Seance(user, header, numberOfPlaces);
        Cinema.getCinema().addSeance(seance);
        return "controller?action=main";
    }

    private String deleteSeance(HttpServletRequest request) {
        Seance seance = Seance.getSeance(request);
        Cinema.getCinema().removeSeance(seance);
        return "controller?action=main";
    }

    private String editSeance(HttpServletRequest request) {
        Seance seance = Seance.getSeance(request);
        seance.setHeader(request.getParameter("header"));
        return "seance.jsp";
    }

    private String getSeance(HttpServletRequest request) {
        Seance seance = Seance.getSeance(request);
        request.setAttribute("seance", seance);
        request.setAttribute("pTickets", seance.getPurchasedTickets());
        return "seance.jsp";
    }
}
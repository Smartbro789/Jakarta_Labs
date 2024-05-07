package controller;

import jakarta.servlet.http.HttpServletRequest;
import model.Cinema;
import model.Seance;

import java.util.ArrayList;



public class MainController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request) {
        Cinema cinema = Cinema.getCinema();
        ArrayList<Seance> seances = cinema.getSeances();
        request.setAttribute("seances", seances);
        return "main.jsp";
    }
}

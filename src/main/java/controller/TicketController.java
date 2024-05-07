package controller;

import jakarta.servlet.http.HttpServletRequest;

import model.Seance;
import model.Ticket;

public class TicketController implements Controller {

    @Override
    public String handleRequest(HttpServletRequest request) {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                return addTicket(request);
            case "buy":
                return buyTicket(request);
            case "delete":
                return deleteTicket(request);
            case "edit":
                return editTicket(request);
            default:
                return null; // Handle invalid action
        }
    }

    private String addTicket(HttpServletRequest request) {
        Seance seance = (Seance) request.getAttribute("seance");
        int cost = Integer.parseInt(request.getParameter("cost"));

        Ticket ticket = new Ticket(seance, cost);
        seance.addTicket(ticket);
        seance.minus();

        request.setAttribute("seance", seance);
        return "seance.jsp";
    }

    private String buyTicket(HttpServletRequest request) {
        Seance seance = (Seance) request.getAttribute("seance");
        String ticketId = request.getParameter("idTicket");
        Ticket ticket = seance.getTicketById(ticketId);

        ticket.setUserName(request.getParameter("name"));
        ticket.setBuy(true);
        seance.addPurchasedTicket(ticket);

        request.setAttribute("seance", seance);
        request.setAttribute("pTickets", seance.getPurchasedTickets());
        return "seance.jsp";
    }

    private String deleteTicket(HttpServletRequest request) {
        Seance seance = (Seance) request.getAttribute("seance");
        Ticket ticket = seance.getTicketById(request.getParameter("idTicket"));
        seance.removeTicket(ticket);
        seance.plus();
        request.setAttribute("seance", seance);
        return "seance.jsp";
    }

    private String editTicket(HttpServletRequest request) {
        Seance seance = (Seance) request.getAttribute("seance");
        Ticket ticket = seance.getTicketById(request.getParameter("idTicket"));
        ticket.setCost(Integer.parseInt(request.getParameter("cost")));
        request.setAttribute("seance", seance);
        return "seance.jsp";
    }
}
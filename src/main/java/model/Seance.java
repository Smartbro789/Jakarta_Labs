package model;

import jakarta.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.List;

public class Seance {
    private static int idCounter = 1;

    private int id;
    private User creator;
    private String header;
    private int numberOfPlaces;
    private List<Ticket> tickets;
    private List<Ticket> purchasedTickets;
    private static Seance instance;

    public Seance(User creator, String header, int numberOfPlaces) {
        this.id = idCounter++;
        this.creator = creator;
        this.header = header;
        this.numberOfPlaces = numberOfPlaces;
        this.tickets = new ArrayList<>();
        this.purchasedTickets = new ArrayList<>();
    }
    public Seance() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addTicket(Ticket ticket) {
        if (tickets == null) {
            tickets = new ArrayList<>();
        }
        tickets.add(ticket);
    }

    public Ticket getTicketById(String ticketId) {
        // Iterate through tickets to find the ticket with the specified ID
        for (Ticket ticket : tickets) {
            if (Integer.valueOf(ticket.getId()).equals(Integer.valueOf(ticketId))) {
                return ticket;
            }
        }
        return null; // Ticket with the specified ID not found
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public List<Ticket> getTicket() {
        return tickets;
    }

    public void setTicket(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Ticket> getPurchasedTickets() {
        return purchasedTickets;
    }

    public void setPurchasedTickets(List<Ticket> purchasedTickets) {
        this.purchasedTickets = purchasedTickets;
    }

    public void addPlace(Ticket ticket) {
        if (tickets.size() < numberOfPlaces) {
            tickets.add(ticket);
        }
    }

    public static Seance getSeance(HttpServletRequest request) {
        if (instance == null) {
            instance = new Seance();
        }
        return instance;
    }

    public void removeTicket(Ticket ticket) {
        tickets.remove(ticket);
    }

    public void addPurchasedTicket(Ticket ticket) {
        purchasedTickets.add(ticket);
    }

    public void plus() {
        numberOfPlaces++;
    }

    public void minus() {
        numberOfPlaces--;
    }
}

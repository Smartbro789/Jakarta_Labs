package model;

public class Ticket {
    private static int ticketCounter = 1;
    private static int idCounter = 1;
    private int number;
    private Seance seance;
    private int cost;
    private String userName;
    private boolean buy;
    private int id;

    public Ticket(Seance seance, int cost) {
        this.number = ticketCounter++;
        this.seance = seance;
        this.cost = cost;
        this.userName = "";
        this.buy = false;
        this.id = idCounter++;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Seance getSeance() {
        return seance;
    }

    public int getId() {
        return id;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isBuy() {
        return buy;
    }

    public void setBuy(boolean buy) {
        this.buy = buy;
    }
}

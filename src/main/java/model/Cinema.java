package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cinema {
    private Map<String, User> users = new HashMap<>();
    private ArrayList<Seance> seances = new ArrayList<>();
    private int id = 0;
    private static Cinema instance;

    public int getId() {
        id++;
        return id;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public void setSeances(List<Seance> seances) {
        this.seances = (ArrayList<Seance>) seances;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean addUser(User user) {
        users.put(user.getName(), user);
        return false;
    }

    public void removeUser(User user) {
        users.remove(user.getName());
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public void addSeance(Seance seance) {
        seances.add(seance);
    }

    public void removeSeance(Seance seance) {
        seances.remove(seance);
    }

    public Map<String, User> getUsers() {
        return users;
    }
    public static Cinema getCinema() {
        if (instance == null) {
            instance = new Cinema();
        }
        return instance;
    }
    public User getUserByName(String name) {
        return users.get(name);
    }
}

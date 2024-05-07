package controller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {
    private static ControllerFactory factory = new ControllerFactory();

    private final Map<String, Controller> controllers = new HashMap<>();

    private ControllerFactory() {
        controllers.put("login", new AuthenticationController());
        controllers.put("logout", new AuthenticationController());
        controllers.put("register", new AuthenticationController());
        controllers.put("create", new SeanceController());
        controllers.put("delete", new SeanceController());
        controllers.put("edit", new SeanceController());
        controllers.put("get", new SeanceController());
        controllers.put("add", new TicketController());
        controllers.put("buy", new TicketController());
        controllers.put("deleteTicket", new TicketController());
        controllers.put("editTicket", new TicketController());
        controllers.put("main", new MainController());
    }

    public static ControllerFactory commandFactory() {
        if (factory == null) {
            factory = new ControllerFactory();
        }
        return factory;
    }

    public Controller getController(String action) {
        return controllers.get(action);
    }
}

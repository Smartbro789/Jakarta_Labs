package controller;

import jakarta.servlet.http.HttpServletRequest;

public interface Controller {
    String handleRequest(HttpServletRequest request);
}

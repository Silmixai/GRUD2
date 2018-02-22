package com.mixail.servlets;

import com.mixail.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DeleteUserServlet extends HttpServlet {
    private Map<Integer, User> users;
    @Override
    public void init() throws ServletException {
     Object users =  getServletContext().getAttribute("users");
      this.users = (ConcurrentHashMap<Integer, User>) users;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        users.remove(Integer.valueOf(req.getParameter("id")));
        resp.sendRedirect(req.getContextPath() + "/");
    }
}

package com.mixail.servlets;

import com.mixail.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class AddUserServlet extends HttpServlet {
    private AtomicInteger id;
    private Map<Integer, User> users;


    @Override
    public void init() throws ServletException {
        users = (Map<Integer, User>) getServletContext().getAttribute("users");
        id = new AtomicInteger(2);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        User user = new User(name, Integer.valueOf(age));

        final int id = this.id.getAndIncrement();
        user.setId(id);
        users.put(id, user);
        request.setAttribute("users", users.values());

       request.getRequestDispatcher("index.jsp").forward(request, response);
       // response.sendRedirect(request.getContextPath() + "/");


    }


}

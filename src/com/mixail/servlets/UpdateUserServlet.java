package com.mixail.servlets;

import com.mixail.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    private Map<Integer, User> users;

    @Override
    public void init() throws ServletException {
        users = (Map<Integer, User>) getServletContext().getAttribute("users");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        User user = users.get(Integer.valueOf(id));
        user.setAge(Integer.parseInt(age));
        user.setName(name);
        users.put(Integer.parseInt(id),user);

        response.sendRedirect(request.getContextPath() + "/");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String id = request.getParameter("id");
        User user = users.get(Integer.parseInt(id));
        request.setAttribute("user", user);
        PrintWriter printWriter = response.getWriter();
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
        requestDispatcher.forward(request, response);

    }
}

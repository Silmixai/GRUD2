package com.mixail.servlets;

import com.mixail.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class GetIndexPageServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = new CopyOnWriteArrayList<>();
        users.add(new User("Java", 10));
        users.add(new User("Vision", 20));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", users);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String age=request.getParameter("age");
        User user= new User(name,Integer.valueOf(age));
        users.add(user);
        doGet(request,response);


    }


}

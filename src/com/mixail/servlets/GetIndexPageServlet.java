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
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class GetIndexPageServlet extends HttpServlet {

    private Map<Integer,User> users;


    @Override
    public void init() throws ServletException {
      Object users=getServletContext().getAttribute("users");
      if(users==null)
      {
          throw new IllegalStateException("You're repository does not initialize!!");
      }
      else this.users= (ConcurrentHashMap<Integer, User>) users;
      User user= new User("igor",20);
      user.setId(1);

      ((ConcurrentHashMap<Integer, User>) users).put(1,user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("users", users.values());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(request, response);

    }


}

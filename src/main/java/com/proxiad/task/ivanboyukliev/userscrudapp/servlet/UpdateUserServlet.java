package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import java.io.IOException;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {

  private static final long serialVersionUID = 345232423L;

  private UserService userService;

  @Override
  public void init() throws ServletException {
    userService = (UserService) getServletContext().getAttribute("userService");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    int userId = Integer.parseInt(req.getParameter("id"));
    String newFirstName = req.getParameter("fname");
    String newLastName = req.getParameter("lname");
    User newUserData = new User(userId, newFirstName, newLastName);
    userService.updateUser(userId, newUserData);

    // Update user data in servlet context and redirect to users list
    getServletContext().setAttribute("users", userService.findAllUsers());
    getServletContext().getRequestDispatcher("/viewUsers.jsp").forward(req, resp);

  }
}

package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.INSERT_USR_URL;
import java.io.IOException;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(INSERT_USR_URL)
public class InserNewUserServlet extends HttpServlet {

  private UserService userService;

  @Override
  public void init() throws ServletException {
    userService = (UserService) getServletContext().getAttribute("userService");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    String firstName = req.getParameter("fname");
    String lastName = req.getParameter("lname");
    User newUser = new User();
    newUser.setFirstName(firstName);
    newUser.setLastName(lastName);
    userService.saveUser(newUser);
    resp.setStatus(HttpServletResponse.SC_CREATED);
    // Update user data in servlet context and redirect to user list
    getServletContext().setAttribute("users", userService.findAllUsers());
    resp.sendRedirect("viewUsers.jsp");;
  }
}

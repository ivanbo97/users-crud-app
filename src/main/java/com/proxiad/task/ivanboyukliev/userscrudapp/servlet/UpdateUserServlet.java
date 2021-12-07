package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.UPDATE_USR_URL;
import java.io.IOException;
import java.util.Optional;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import com.proxiad.task.ivanboyukliev.userscrudapp.utils.HtmlErrorGenerator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(UPDATE_USR_URL)
public class UpdateUserServlet extends HttpServlet {

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
    Optional<User> updatedUser = userService.updateUser(userId, newUserData);

    if (updatedUser.isEmpty()) {
      // In case of user being deleted by another client during filling new data
      resp.getWriter().write(HtmlErrorGenerator.generateNotExisitngStudentErr());
      return;
    }

    // Update user data in servlet context and redirect to users list
    getServletContext().setAttribute("users", userService.findAllUsers());
    resp.sendRedirect("viewUsers.jsp");
  }
}

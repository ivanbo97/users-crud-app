package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import java.io.IOException;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getAllUsrs")
public class GetAllUsersServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private UserService userService;

  @Override
  public void init() throws ServletException {
    userService = (UserService) getServletContext().getAttribute("userService");
  }

  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    getServletContext().setAttribute("users", userService.findAllUsers());
    getServletContext().getRequestDispatcher("/viewUsers.jsp").forward(req, res);
  }

}

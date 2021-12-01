package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.GET_ALL_USRS_URL;
import java.io.IOException;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;;

@WebServlet(GET_ALL_USRS_URL)
public class GetAllUsersServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  private UserService userService;

  @Override
  public void init() throws ServletException {
    userService = (UserService) getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {

    getServletContext().setAttribute("users", userService.findAllUsers());
    getServletContext().getRequestDispatcher("/viewUsers.jsp").forward(req, res);
  }

}

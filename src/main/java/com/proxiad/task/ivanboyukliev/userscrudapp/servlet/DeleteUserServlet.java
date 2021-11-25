package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import java.io.IOException;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteUserServlet extends HttpServlet {

  private static final long serialVersionUID = 83727842346L;

  private UserService userService = new UserServiceImpl();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    userService.deleteUserById(id);
    getServletContext().setAttribute("users", userService.findAllUsers());
    getServletContext().getRequestDispatcher("/viewUsers.jsp").forward(req, resp);
  }


}

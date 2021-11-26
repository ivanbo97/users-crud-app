package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.UPDATE_USR_REQ;
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

@WebServlet(UPDATE_USR_REQ)
public class UpdateUserRequestServlet extends HttpServlet {

  private UserService userService;

  @Override
  public void init() throws ServletException {
    userService = (UserService) getServletContext().getAttribute("userService");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));

    Optional<User> retrievedUser = userService.findUserById(id);

    if (retrievedUser.isEmpty()) {
      resp.getWriter().write(HtmlErrorGenerator.generateNotExisitngStudentErr());
      return;
    }

    getServletContext().setAttribute("user", retrievedUser.get());
    getServletContext().getRequestDispatcher("/editUser.jsp").forward(req, resp);
  }

}

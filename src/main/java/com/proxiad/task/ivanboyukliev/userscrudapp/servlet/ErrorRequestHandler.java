package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/invalidReqHandler")
public class ErrorRequestHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processError(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processError(req, resp);
  }

  private void processError(HttpServletRequest req, HttpServletResponse resp) throws IOException {

    EntityValidationException exception =
        (EntityValidationException) req.getAttribute("jakarta.servlet.error.exception");

    try (PrintWriter writer = resp.getWriter()) {
      writer.write("<!DOCTYPE html><html><head><title>Error description</title></head><body>");
      writer.write("<h2>Error description</h2>");
      writer.write("<ul>");

      Arrays.asList(HttpServletResponse.SC_BAD_REQUEST, exception.getClass().getName(),
          exception.getMessage()).forEach(e -> writer.write("<li>" + e + "</li>"));

      writer.write("</ul>");
      writer.write("</html></body>");
      resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
    }
  }


}


package com.proxiad.task.ivanboyukliev.userscrudapp.listeners;

import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class UserServiceLoader implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    sce.getServletContext().setAttribute("userService", new UserServiceImpl());
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    sce.getServletContext().removeAttribute("userService");
  }
}

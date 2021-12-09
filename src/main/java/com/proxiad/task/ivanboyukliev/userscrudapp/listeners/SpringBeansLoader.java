package com.proxiad.task.ivanboyukliev.userscrudapp.listeners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import com.proxiad.task.ivanboyukliev.userscrudapp.spring.config.SpringContainerConfigurator;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SpringBeansLoader implements ServletContextListener {

  private AnnotationConfigApplicationContext springContainer;

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // Initialize Spring Container
    springContainer = new AnnotationConfigApplicationContext(SpringContainerConfigurator.class);

    // Loading Spring Beans inside Servlet context
    UserService userService = springContainer.getBean(UserService.class);
    sce.getServletContext().setAttribute("userService", userService);

  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    sce.getServletContext().removeAttribute("userService");
    springContainer.close();
  }

}

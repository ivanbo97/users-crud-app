package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.proxiad.task.ivanboyukliev.userscrudapp.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class GetAllUsersServletTest {

  @Spy
  @InjectMocks
  private GetAllUsersServlet servlet;

  @Mock
  private UserService userService;

  @Mock
  private ServletConfig servletConfig;

  @Mock
  private HttpServletRequest httpRequest;

  @Mock
  private HttpServletResponse httpResponse;

  @Mock
  private ServletContext servletContext;

  @Mock
  private RequestDispatcher requestDispatcher;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testDoGet() throws Exception {

    given(servlet.getServletConfig()).willReturn(servletConfig);
    given(servlet.getServletContext()).willReturn(servletContext);
    given(servletContext.getRequestDispatcher(anyString())).willReturn(requestDispatcher);
    given(servletContext.getAttribute("userService")).willReturn(userService);

    // when
    servlet.init();
    servlet.doGet(httpRequest, httpResponse);

    // then
    then(userService).should().findAllUsers();
    then(servletContext).should().setAttribute(eq("users"), any(Collection.class));
  }

}

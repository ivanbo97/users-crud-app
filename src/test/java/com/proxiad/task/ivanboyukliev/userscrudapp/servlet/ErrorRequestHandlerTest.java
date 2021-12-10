package com.proxiad.task.ivanboyukliev.userscrudapp.servlet;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import java.io.PrintWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

class ErrorRequestHandlerTest {

  @Spy
  private ErrorRequestHandler errorServlet;

  @Mock
  private ServletConfig servletConfig;

  @Mock
  private HttpServletRequest httpRequest;

  @Mock
  private HttpServletResponse httpResponse;

  @Mock
  private ServletOutputStream servletOutputStream;

  @Mock
  private PrintWriter printWriter;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void errorHandlingTest() throws Exception {
    // given
    given(errorServlet.getServletConfig()).willReturn(servletConfig);
    given(httpResponse.getOutputStream()).willReturn(servletOutputStream);
    given(httpResponse.getWriter()).willReturn(printWriter);
    given(httpRequest.getAttribute("jakarta.servlet.error.exception"))
        .willReturn(new EntityValidationException());

    // when
    errorServlet.doGet(httpRequest, httpResponse);
    // then
    then(httpResponse).should().setStatus(HttpServletResponse.SC_BAD_REQUEST);
  }

}

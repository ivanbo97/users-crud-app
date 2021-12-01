package com.proxiad.task.ivanboyukliev.userscrudapp.exception;

import jakarta.servlet.ServletException;

public class EntityValidationException extends ServletException {

  public EntityValidationException() {
    super();
  }

  public EntityValidationException(String message) {
    super(message);
  }

  public EntityValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  public EntityValidationException(Throwable cause) {
    super(cause);
  }
}

package com.proxiad.task.ivanboyukliev.userscrudapp.validation;

import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;

public interface EntityValidator<T> {

  void validate(T entity) throws EntityValidationException;
}

package com.proxiad.task.ivanboyukliev.userscrudapp.validation;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_NAME_IS_BLANK;
import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_NAME_IS_EMPTY;
import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_NAME_IS_NULL;
import org.springframework.stereotype.Component;
import com.proxiad.task.ivanboyukliev.userscrudapp.baseentity.BaseNamedEntity;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;

@Component
public class BaseNamedEntityValidator implements EntityValidator<BaseNamedEntity> {

  @Override
  public void validate(BaseNamedEntity entity) throws EntityValidationException {

    String entityName = entity.getName();
    this.validateName(entityName);
  }

  private void validateName(String entityName) throws EntityValidationException {
    if (entityName == null) {
      throw new EntityValidationException(ERROR_ENTITY_NAME_IS_NULL);
    }
    if (entityName.isEmpty()) {
      throw new EntityValidationException(ERROR_ENTITY_NAME_IS_EMPTY);
    }
    if (entityName.isBlank()) {
      throw new EntityValidationException(ERROR_ENTITY_NAME_IS_BLANK);
    }
  }

}

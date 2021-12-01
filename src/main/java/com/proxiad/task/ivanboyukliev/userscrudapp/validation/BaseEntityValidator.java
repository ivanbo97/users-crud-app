package com.proxiad.task.ivanboyukliev.userscrudapp.validation;


import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_ID_IS_NULL;
import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_IS_NULL;
import com.proxiad.task.ivanboyukliev.userscrudapp.baseentity.BaseEntity;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;

public class BaseEntityValidator implements EntityValidator<BaseEntity> {

  @Override
  public void validate(BaseEntity entity) throws EntityValidationException {
    if (entity == null) {
      throw new EntityValidationException(ERROR_ENTITY_IS_NULL);
    }

    if (entity.getId() == null) {
      throw new EntityValidationException(ERROR_ENTITY_ID_IS_NULL);
    }
  }
}

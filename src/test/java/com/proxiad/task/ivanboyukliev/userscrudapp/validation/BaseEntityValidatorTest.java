package com.proxiad.task.ivanboyukliev.userscrudapp.validation;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_ID_IS_NULL;
import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_IS_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.proxiad.task.ivanboyukliev.userscrudapp.baseentity.BaseEntity;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;

class BaseEntityValidatorTest {

  private BaseEntityValidator entityValidator = new BaseEntityValidator();

  @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER)
  @MethodSource("supplyEntites")
  void validate(BaseEntity entity, String errorMessage) {
    Exception exception =
        assertThrows(EntityValidationException.class, () -> entityValidator.validate(entity));

    assertThat(exception.getMessage()).isEqualTo(errorMessage);
  }

  private static Stream<Arguments> supplyEntites() {
    return Stream.of(Arguments.of(null, ERROR_ENTITY_IS_NULL),
        Arguments.of(new User(null, "Valentino", "Rossi"), ERROR_ENTITY_ID_IS_NULL));
  }

  @Test
  void successfulValidationTest() throws Exception {
    // given
    User user = new User(1, "Travis", "Pastrana");
    // then
    assertDoesNotThrow(() -> entityValidator.validate(user));
  }
}

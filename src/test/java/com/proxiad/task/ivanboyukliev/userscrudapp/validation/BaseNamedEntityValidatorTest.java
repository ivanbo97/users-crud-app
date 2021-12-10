package com.proxiad.task.ivanboyukliev.userscrudapp.validation;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_NAME_IS_BLANK;
import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_NAME_IS_EMPTY;
import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.ERROR_ENTITY_NAME_IS_NULL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.proxiad.task.ivanboyukliev.userscrudapp.baseentity.BaseNamedEntity;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;

class BaseNamedEntityValidatorTest {

  private BaseNamedEntityValidator entityValidator = new BaseNamedEntityValidator();

  @ParameterizedTest(name = ARGUMENTS_PLACEHOLDER)
  @MethodSource("supplyEntites")
  void validate(BaseNamedEntity entity, String errorMessage) {
    Exception exception =
        assertThrows(EntityValidationException.class, () -> entityValidator.validate(entity));

    assertThat(exception.getMessage()).isEqualTo(errorMessage);
  }

  @Test
  private static Stream<Arguments> supplyEntites() {

    return Stream.of(Arguments.of(new User(1, null, null), ERROR_ENTITY_NAME_IS_NULL),
        Arguments.of(new User(2, "", ""), ERROR_ENTITY_NAME_IS_EMPTY),
        Arguments.of(new User(3, " ", " "), ERROR_ENTITY_NAME_IS_BLANK));
  }

  @Test
  void successfulValidationTest() throws Exception {
    // given
    User user = new User(1, "Tony", "Hawk");
    // then
    assertDoesNotThrow(() -> entityValidator.validate(user));
  }
}

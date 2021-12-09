package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;
import com.proxiad.task.ivanboyukliev.userscrudapp.repository.UserRepository;
import com.proxiad.task.ivanboyukliev.userscrudapp.validation.BaseNamedEntityValidator;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

  @Mock
  private UserRepository userRepository;

  @Mock
  private BaseNamedEntityValidator entityValidator;

  private UserService userService;

  private static User firstExampleUser;
  private static User secondExampleUser;

  @BeforeAll
  static void populateUserData() {
    firstExampleUser = new User(1, "Helly", "Hansen");
    secondExampleUser = new User(1, "Tommy", "Hilfiger");
  }

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
    userService = new UserServiceImpl(userRepository, entityValidator);
  }

  @Test
  void findAllUsers() {


    // given
    Set<User> users = new HashSet<>();
    users.add(firstExampleUser);
    users.add(secondExampleUser);
    given(userRepository.findAll()).willReturn(users);

    // when
    List<User> retrievedUsers = userService.findAllUsers();

    // then
    assertThat(retrievedUsers).isNotNull().isNotEmpty().doesNotContainNull().hasSize(2)
        .contains(firstExampleUser);

  }



  @Test
  void findUserById() {

    // given
    given(userRepository.findById(anyInt())).willReturn(Optional.of(firstExampleUser));

    // when
    Optional<User> retrievedUser = userService.findUserById(1);

    // then
    assertFalse(retrievedUser.isEmpty());
    assertEquals(firstExampleUser.getFirstName(), retrievedUser.get().getFirstName());
    then(userRepository).should().findById(anyInt());

  }

  @Test
  void saveUser() throws EntityValidationException {

    // given

    // when
    userService.saveUser(secondExampleUser);

    // then
    then(entityValidator).should().validate(any(User.class));
    then(userRepository).should().addUser(secondExampleUser);
  }

  @Test
  void updateUser() throws EntityValidationException {

    // given
    User updateUserData = new User();
    updateUserData.setFirstName("Glen");
    updateUserData.setLastName("Fidich");
    given(userRepository.updateUser(anyInt(), any(User.class)))
        .willReturn(Optional.of(updateUserData));

    // when
    Optional<User> updatedUser = userService.updateUser(1, updateUserData);


    // then
    then(entityValidator).should().validate(any(User.class));
    then(userRepository).should().updateUser(anyInt(), any(User.class));
    assertThat(updatedUser).isNotEmpty();
    assertThat(updatedUser.get().getFirstName()).isEqualTo("Glen");
  }

  @Test
  void deleteUserById() throws Exception {

    // when
    userService.deleteUserById(1);

    // then
    then(userRepository).should().deleteUserById(anyInt());
  }
}

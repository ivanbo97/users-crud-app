package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;
import com.proxiad.task.ivanboyukliev.userscrudapp.repository.UserRepository;
import com.proxiad.task.ivanboyukliev.userscrudapp.utils.SortUsersByIdAscending;
import com.proxiad.task.ivanboyukliev.userscrudapp.validation.BaseNamedEntityValidator;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  private final BaseNamedEntityValidator entityValidator;

  @Autowired
  public UserServiceImpl(UserRepository userRepository, BaseNamedEntityValidator entityValidator) {
    this.userRepository = userRepository;
    this.entityValidator = entityValidator;
  }

  @Override
  public List<User> findAllUsers() {
    Set<User> currentUsers = userRepository.findAll();
    List<User> sortedUsers = new ArrayList<>(currentUsers);
    Collections.sort(sortedUsers, new SortUsersByIdAscending());
    return sortedUsers;
  }

  @Override
  public Optional<User> findUserById(int userId) {
    return userRepository.findById(userId);
  }

  @Override
  public void saveUser(User newUser) throws EntityValidationException {
    entityValidator.validate(newUser);
    userRepository.addUser(newUser);
  }

  @Override
  public Optional<User> updateUser(int userId, User newUserData) throws EntityValidationException {
    entityValidator.validate(newUserData);
    return userRepository.updateUser(userId, newUserData);
  }

  @Override
  public void deleteUserById(int userId) {
    userRepository.deleteUserById(userId);
  }

}

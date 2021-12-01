package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import java.util.List;
import java.util.Optional;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.exception.EntityValidationException;

public interface UserService {
  List<User> findAllUsers();

  Optional<User> findUserById(int userId);

  void saveUser(User newUser) throws EntityValidationException;

  Optional<User> updateUser(int userId, User newUserData) throws EntityValidationException;

  void deleteUserById(int userId);

}

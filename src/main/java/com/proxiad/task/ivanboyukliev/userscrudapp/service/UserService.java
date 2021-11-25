package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import java.util.List;
import java.util.Optional;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;

public interface UserService {
  List<User> findAllUsers();

  Optional<User> findUserById(int userId);

  void saveUser(User newUser);

  void updateUser(int userId, User newUserData);

  void deleteUserById(int userId);

}

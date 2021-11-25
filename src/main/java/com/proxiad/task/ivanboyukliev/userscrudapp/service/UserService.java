package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import java.util.List;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;

public interface UserService {
  List<User> findAllUsers();

  void saveUser(User newUser);

  void updateUser(User userForAupdate, User newUserData);

  void deleteUserById(int userId);
}

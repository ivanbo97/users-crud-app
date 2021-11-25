package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.repository.UserRepository;
import com.proxiad.task.ivanboyukliev.userscrudapp.utils.SortUsersByIdAscending;

public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl() {
    userRepository = UserRepository.getInstance();
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
  public void saveUser(User newUser) {
    userRepository.addUser(newUser);
  }

  @Override
  public void updateUser(int userId, User newUserData) {
    userRepository.updateUser(userId, newUserData);
  }

  @Override
  public void deleteUserById(int userId) {
    userRepository.deleteUserById(userId);
  }

}

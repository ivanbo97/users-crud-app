package com.proxiad.task.ivanboyukliev.userscrudapp.service;

import java.util.List;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.repository.UserRepository;

public class UserServiceImpl implements UserService {

  private UserRepository userRepository;


  public UserServiceImpl() {
    userRepository = UserRepository.getInstance();
  }

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public void saveUser(User newUser) {
    userRepository.addUser(newUser);
  }

  @Override
  public void updateUser(User userForAupdate, User newUserData) {
    userRepository.updateUser(userForAupdate, newUserData);
  }

  @Override
  public void deleteUserById(int userId) {
    userRepository.deleteUserById(userId);
  }

}

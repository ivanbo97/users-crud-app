package com.proxiad.task.ivanboyukliev.userscrudapp.repository;


import java.util.ArrayList;
import java.util.List;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;

public class UserRepository {

  private List<User> users = new ArrayList<>();

  private UserRepository() {
    populateRepository();
  }

  private static class SingletonHelper {
    private static final UserRepository uniqueUnstance = new UserRepository();

  }

  public static UserRepository getInstance() {
    // Here class loader loads SingletonHelper class, and therefore
    // uniqueInstance is created. Remember: Class is loaded only once,
    // when it is first referenced in source code. (Bill Pugh approach of singleton)
    return SingletonHelper.uniqueUnstance;
  }

  private void populateRepository() {
    users.add(new User(1, "John", "Doe"));
    users.add(new User(2, "Ivan", "Doe"));
    users.add(new User(3, "Maggy", "Doe"));
    users.add(new User(4, "Merry", "Christmas"));
    users.add(new User(5, "Happy", "Newyear"));
    users.add(new User(6, "Sarah", "Michael"));
  }

  public List<User> findAll() {
    return users;
  }

  public void addUser(User newUser) {
    users.add(newUser);
  }

  public void deleteUserById(int id) {
    users.remove(id);
  }

  public void updateUser(User userForUpdate, User newUserData) {
    if (users.contains(userForUpdate)) {
      users.set(userForUpdate.getId(), newUserData);
    }
  }
}

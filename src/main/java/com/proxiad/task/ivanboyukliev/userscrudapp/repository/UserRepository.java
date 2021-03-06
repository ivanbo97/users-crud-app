package com.proxiad.task.ivanboyukliev.userscrudapp.repository;


import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;
import com.proxiad.task.ivanboyukliev.userscrudapp.utils.RandomNumberGenerator;

public class UserRepository {

  private Set<User> users = Collections.synchronizedSet(new HashSet<User>());

  private UserRepository() {
    populateRepository();
  }

  // static inner class - inner classes are not loaded until they are
  // referenced.
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

  public Set<User> findAll() {
    return users;
  }

  public void addUser(User newUser) {
    int userId;
    do {
      userId = RandomNumberGenerator.generateRandomNUmber();
      newUser.setId(userId);
    } while (!users.add(newUser));
  }

  public void deleteUserById(int id) {

    Optional<User> foundUser = findById(id);
    if (foundUser.isPresent()) {
      users.remove(foundUser.get());
    }
  }

  public Optional<User> updateUser(int userId, User newUserData) {
    Optional<User> retrievedUser = findById(userId);
    Optional<User> updatedUser = Optional.empty();

    if (retrievedUser.isPresent()) {
      users.remove(retrievedUser.get());
      users.add(newUserData);
      updatedUser = Optional.of(newUserData);
    }
    return updatedUser;
  }

  public Optional<User> findById(int id) {
    Optional<User> foundUserOptional = Optional.empty();
    for (User user : users) {
      if (user.getId() == id)
        foundUserOptional = Optional.of(user);
    }
    return foundUserOptional;
  }
}

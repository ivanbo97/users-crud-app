package com.proxiad.task.ivanboyukliev.userscrudapp.utils;

import java.util.Comparator;
import com.proxiad.task.ivanboyukliev.userscrudapp.domain.User;

public class SortUsersByIdAscending implements Comparator<User> {

  @Override
  public int compare(User user1, User user2) {
    return user1.getId() - user2.getId();
  }
}

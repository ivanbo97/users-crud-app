package com.proxiad.task.ivanboyukliev.userscrudapp.utils;

public class RandomNumberGenerator {

  public static final int MAX_NUMBER = 100;

  public static final int MIN_NUMBER = 7;

  public static int generateRandomNUmber() {
    return (int) ((Math.random() * (MAX_NUMBER - MIN_NUMBER)) + MIN_NUMBER);
  }
}

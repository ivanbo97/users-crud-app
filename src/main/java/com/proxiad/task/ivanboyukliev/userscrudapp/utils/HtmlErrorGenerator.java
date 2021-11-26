package com.proxiad.task.ivanboyukliev.userscrudapp.utils;

import static com.proxiad.task.ivanboyukliev.userscrudapp.utils.ApplicationConstants.GET_ALL_USRS_URL;

public class HtmlErrorGenerator {

  public static final String NOT_FOUND_USR_HTML_ERR =
      "<p style = \"color:navy;font-size:50px;font-family:verdana\">"
          + "The user you want to manage no longer exists!</p><br><br>"
          + "<a style =\"color:navy;font-size:20px;font-family:verdana\" href=\""
          + GET_ALL_USRS_URL.substring(1) + "\">Return to User List</a>";



  public static String generateNotExisitngStudentErr() {
    return NOT_FOUND_USR_HTML_ERR;
  }
}

package com.proxiad.task.ivanboyukliev.userscrudapp.domain;

import java.util.Objects;
import com.proxiad.task.ivanboyukliev.userscrudapp.baseentity.BaseEntity;
import com.proxiad.task.ivanboyukliev.userscrudapp.baseentity.BaseNamedEntity;

public class User implements BaseNamedEntity, BaseEntity {

  private Integer id;
  private String firstName;
  private String lastName;

  public User() {

  }

  public User(Integer id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, id, lastName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    User other = (User) obj;
    return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
        && Objects.equals(lastName, other.lastName);
  }

  @Override
  public String getName() {
    if (firstName == null || lastName == null) {
      return null;
    }
    return firstName + lastName;
  }

}

package com.springbootrest.data.vo.v2;

import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonVO2 implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  long id;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;
  private Date birthDay;

  public PersonVO2() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, birthDay, firstName, gender, id, lastName);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    PersonVO2 other = (PersonVO2) obj;
    return Objects.equals(address, other.address) && Objects.equals(birthDay, other.birthDay)
        && Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
        && id == other.id
        && Objects.equals(lastName, other.lastName);
  }

}

package com.springbootrest.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import java.io.Serial;
import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;

@JsonPropertyOrder({"id", "firstName", "lastName", "address", "gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  @Mapping("id")
  long key;
  private String firstName;
  private String lastName;
  private String address;
  private String gender;

  public PersonVO() {
  }

  public long getKey() {
    return key;
  }

  public void setKey(long key) {
    this.key = key;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    PersonVO personVO = (PersonVO) o;

    if (getKey() != personVO.getKey()) {
      return false;
    }
    if (!getFirstName().equals(personVO.getFirstName())) {
      return false;
    }
    if (!getLastName().equals(personVO.getLastName())) {
      return false;
    }
    if (!getAddress().equals(personVO.getAddress())) {
      return false;
    }
    return getGender().equals(personVO.getGender());
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (int) (getKey() ^ (getKey() >>> 32));
    result = 31 * result + getFirstName().hashCode();
    result = 31 * result + getLastName().hashCode();
    result = 31 * result + getAddress().hashCode();
    result = 31 * result + getGender().hashCode();
    return result;
  }
}

package com.springbootrest.mapper.custom;

import com.springbootrest.data.vo.v1.PersonVO;
import com.springbootrest.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonMapper {

  public Person convertVoToEntity(PersonVO person) {
    Person entity = new Person();

    entity.setId(person.getKey());
    entity.setAddress(person.getAddress());
    entity.setFirstName(person.getFirstName());
    entity.setLastName(person.getLastName());
    entity.setGender(person.getGender());

    return entity;

  }

}

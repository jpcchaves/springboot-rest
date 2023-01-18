package com.springbootrest.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.springbootrest.data.vo.v2.PersonVO2;
import com.springbootrest.model.Person;

@Service
public class PersonMapper {

	public PersonVO2 convertEntityToVo(Person person) {
		PersonVO2 vo = new PersonVO2();

		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());

		return vo;

	}

	public Person convertVoToEntity(PersonVO2 person) {
		Person entity = new Person();

		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
//		entity.setBirthDay(new Date());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());

		return entity;

	}

}

package com.springbootrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.data.vo.v1.PersonVO;
import com.springbootrest.exceptions.ResourceNotFoundException;
import com.springbootrest.mapper.DozerMapper;
import com.springbootrest.model.Person;
import com.springbootrest.repositories.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository personRepository;

	public List<PersonVO> findAll() {
		return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
	}

	public PersonVO findById(Long id) {

		var entity = personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrada uma pessoa com o ID informado."));

		return DozerMapper.parseObject(entity, PersonVO.class);

	}

	public PersonVO createPerson(PersonVO person) {

		var entity = DozerMapper.parseObject(person, Person.class);

		var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

		return vo;
	}

	public PersonVO updatePerson(PersonVO person) {

		var entity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrada uma pessoa com o ID informado."));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);

		return vo;
	}

	public void deletePerson(Long id) {

		var entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Não foi possível deletar a pessoa porque o ID informado não foi encontrado"));

		personRepository.delete(entity);
		;

	}
}

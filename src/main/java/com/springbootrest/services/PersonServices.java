package com.springbootrest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootrest.exceptions.ResourceNotFoundException;
import com.springbootrest.model.Person;
import com.springbootrest.repositories.PersonRepository;

@Service
public class PersonServices {

	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository personRepository;

	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person findById(Long id) {

		logger.info("Finding one person");

		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrada uma pessoa com o ID informado."));
	}

	public Person createPerson(Person person) {
		return personRepository.save(person);
	}

	public Person updatePerson(Person person) {

		Person entity = personRepository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Não foi encontrada uma pessoa com o ID informado."));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return personRepository.save(person);
	}

	public void deletePerson(Long id) {

		Person entity = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
				"Não foi possível deletar a pessoa porque o ID informado não foi encontrado"));

		personRepository.delete(entity);
		;

	}
}

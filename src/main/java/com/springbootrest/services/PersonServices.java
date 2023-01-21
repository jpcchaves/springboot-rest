package com.springbootrest.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.springbootrest.controllers.PersonController;
import com.springbootrest.data.vo.v1.PersonVO;
import com.springbootrest.exceptions.ResourceNotFoundException;
import com.springbootrest.mapper.DozerMapper;
import com.springbootrest.mapper.custom.PersonMapper;
import com.springbootrest.model.Person;
import com.springbootrest.repositories.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonServices {

  @Autowired
  PersonRepository personRepository;

  @Autowired
  PersonMapper mapper;

  public List<PersonVO> findAll() {
    var persons = DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);

    persons.stream().forEach(
        p -> {
          try {
            p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel());
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        });

    return persons;
  }

  public PersonVO findById(Long id) throws Exception {

    var entity = personRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Não foi encontrada uma pessoa com o ID informado."));

    var vo = DozerMapper.parseObject(entity, PersonVO.class);

    vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
    return vo;
  }

  public PersonVO createPerson(PersonVO person) throws Exception {
    var entity = DozerMapper.parseObject(person, Person.class);
    var vo = DozerMapper.parseObject(personRepository.save(entity), PersonVO.class);
    vo.add(linkTo(methodOn(PersonController.class).findById(vo.getKey())).withSelfRel());

    return vo;
  }

  public PersonVO updatePerson(PersonVO person) {

    var entity = personRepository.findById(person.getKey())
        .orElseThrow(() -> new ResourceNotFoundException(
            "Não foi encontrada uma pessoa com o ID informado."));

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

  }

}

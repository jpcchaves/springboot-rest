package com.springbootrest.controllers;

import com.springbootrest.data.vo.v1.PersonVO;
import com.springbootrest.services.PersonServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {

  @Autowired
  private PersonServices service;

  @GetMapping(produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public List<PersonVO> findAll() {
    return service.findAll();
  }

  @GetMapping(value = "/{id}", produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public PersonVO findById(@PathVariable(value = "id") Long id) throws Exception {
    return service.findById(id);
  }

  @PostMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public PersonVO createPersonVO(@RequestBody PersonVO person) throws Exception {
    return service.createPerson(person);
  }

  @PutMapping(consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
  public PersonVO updatePersonVO(@RequestBody PersonVO person) {
    return service.updatePerson(person);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deletePersonVO(@PathVariable(value = "id") Long id) {
    service.deletePerson(id);
    return ResponseEntity.noContent().build();
  }

}

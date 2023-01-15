package com.springbootrest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrest.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

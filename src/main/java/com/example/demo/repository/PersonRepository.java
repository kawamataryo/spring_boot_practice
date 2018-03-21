package com.example.demo.repository;

import com.example.demo.model.Person;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Person.class, idClass = Integer.class)
public interface PersonRepository {
  Person save(Person person);
  Iterable<Person> findAll();
  Iterable<Person> findByAgeIs(int age);
}

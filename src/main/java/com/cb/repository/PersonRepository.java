package com.cb.repository;

import org.springframework.data.repository.CrudRepository;

import com.cb.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {

}

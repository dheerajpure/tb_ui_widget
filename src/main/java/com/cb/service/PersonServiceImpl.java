package com.cb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cb.model.Person;
import com.cb.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void createPerson(Person person) {
		personRepository.save(person);
	}

	@Override
	public List<Person> getPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@Override
	public Person getPerson(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person updatePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(Long id) {
		personRepository.delete(id);
	}

	@Override
	public void deletePersons() {
		personRepository.deleteAll();
	}

}

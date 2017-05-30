package com.cb.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cb.model.Person;
import com.cb.service.PersonService;

@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonController {

	protected static Logger log = LoggerFactory.getLogger(PersonController.class);
	private Long beginSysTime = null;
	private Long endSysTime = null;
	private BigDecimal time = null;

	@Autowired
	private PersonService personService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<?> create(@RequestBody Person person) {
		beginSysTime = System.currentTimeMillis();

		personService.createPerson(person);

		endSysTime = System.currentTimeMillis();
		time = new BigDecimal((endSysTime - beginSysTime)).divide(new BigDecimal("1000"), 4, RoundingMode.CEILING);
		log.info("Class:{} :: Method:{} - Time:{} seconds", this.getClass().getName(), "create", time);
		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getPersons() {
		beginSysTime = System.currentTimeMillis();
		ResponseEntity<List<Person>> response = null;

		List<Person> persons = personService.getPersons();

		if (persons.isEmpty()) {
			response = new ResponseEntity<List<Person>>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
		}

		endSysTime = System.currentTimeMillis();
		time = new BigDecimal((endSysTime - beginSysTime)).divide(new BigDecimal("1000"), 4, RoundingMode.CEILING);
		log.info("Class:{} :: Method:{} - Time:{} seconds", this.getClass().getName(), "getPersons", time);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getPerson(@PathVariable final Long id) {
		beginSysTime = System.currentTimeMillis();
		ResponseEntity<Person> response = null;

		Person person = personService.getPerson(id);

		if (person == null) {
			response = new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<Person>(person, HttpStatus.OK);
		}

		endSysTime = System.currentTimeMillis();
		time = new BigDecimal((endSysTime - beginSysTime)).divide(new BigDecimal("1000"), 4, RoundingMode.CEILING);
		log.info("Class:{} :: Method:{} - Time:{} seconds", this.getClass().getName(), "getPerson", time);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody ResponseEntity<?> updatePerson(@PathVariable final Long id, @RequestBody Person person) {
		beginSysTime = System.currentTimeMillis();

		ResponseEntity<Person> response = null;
		Person currentPerson = personService.getPerson(id);

		if (currentPerson == null) {
			response = new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else {
			currentPerson.setName(person.getName());
			Person updatedPerson = personService.updatePerson(currentPerson);
			response = new ResponseEntity<Person>(updatedPerson, HttpStatus.OK);
		}

		endSysTime = System.currentTimeMillis();
		time = new BigDecimal((endSysTime - beginSysTime)).divide(new BigDecimal("1000"), 4, RoundingMode.CEILING);
		log.info("Class:{} :: Method:{} - Time:{} seconds", this.getClass().getName(), "updatePerson", time);
		return response;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody ResponseEntity<?> deletePerson(@PathVariable final Long id) {
		beginSysTime = System.currentTimeMillis();

		ResponseEntity<Person> response = null;
		Person person = personService.getPerson(id);

		if (person == null) {
			response = new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		} else {
			personService.deletePerson(id);
			response = new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
		}

		endSysTime = System.currentTimeMillis();
		time = new BigDecimal((endSysTime - beginSysTime)).divide(new BigDecimal("1000"), 4, RoundingMode.CEILING);
		log.info("Class:{} :: Method:{} - Time:{} seconds", this.getClass().getName(), "deletePerson", time);
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePersons() {
		beginSysTime = System.currentTimeMillis();

		personService.deletePersons();

		endSysTime = System.currentTimeMillis();
		time = new BigDecimal((endSysTime - beginSysTime)).divide(new BigDecimal("1000"), 4, RoundingMode.CEILING);
		log.info("Class:{} :: Method:{} - Time:{} seconds", this.getClass().getName(), "deletePersons", time);

		return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
	}
}

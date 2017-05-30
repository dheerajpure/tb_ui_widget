package com.cb.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import com.cb.config.JpaIntegrationConfig;
import com.cb.model.Person;
/*@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@PropertySource(value = {"classpath:application.properties"})
//@WebMvcTest(PersonController.class)
*/

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringApplicationConfiguration(JpaIntegrationConfig.class)
//@ActiveProfiles("jpadao")
public class PersonServiceImplTest {

	
	@Autowired
	private PersonService personService;
	
/*	@Autowired
	private WebApplicationContext context;*/
/*
	@Autowired
    private TestRestTemplate restTemplate;*/
	
	/* @Autowired
	    private TestEntityManager entityManager;
	 */
/*	private MockMvc mvc;*/
	
	/*@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}*/
	
	@Test
	public void testCreatePerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPersons() throws Exception {
		
		System.out.println("------------------------------------+++++++++++++++++++");
		
		//entityManager.getEntityManager().
		
		//this.mvc.perform(get("/"));
		//String body = this.restTemplate.getForObject("/", String.class);
		
		/*Person person = new Person();
		person.setId(1L);
		person.setName("dheeraj");
		personService.createPerson(person);*/
		
		List<Person> persons = (List<Person>) personService.getPersons();
		System.out.println("persons "+persons);
		System.out.println("------------------------------------+++++++++++++++++++");
	}

	@Test
	public void testGetPerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdatePerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePerson() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePersons() {
		fail("Not yet implemented");
	}

	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

}

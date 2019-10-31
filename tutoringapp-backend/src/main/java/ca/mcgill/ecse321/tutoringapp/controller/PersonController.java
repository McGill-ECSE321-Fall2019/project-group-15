package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dto.PersonDto;
import ca.mcgill.ecse321.tutoringapp.service.PersonService;

@CrossOrigin(origins = "*")
@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@PostMapping(value = {"/createPerson/", "/createPerson"})
	public PersonDto createPerson(
		@RequestParam("personID") Integer personID,
		@RequestParam("firstName") String firstName,
		@RequestParam("lastName") String lastName,
		@RequestParam("userName") String userName ) 
		throws IllegalArgumentException {
		Person person = personService.createPerson(personID, firstName, lastName, userName);
		return DtoConverters.convertToDto(person);
	}

	@GetMapping(value = {"/getAllPersons","/getAllPersons/"})
	public List<PersonDto> getAllPersons() {
		
		return null;
	}
	
	@GetMapping(value = {"/getPersonByPersonID/","getPersonByPersonID"})
	public PersonDto getPersonByPersonID(
		@RequestParam("personID") Integer personID)
		throws IllegalArgumentException {
		
		return null;
	}
	
	@GetMapping(value = {"getPersonByUsername","GetPersonByUsername"})
	public PersonDto getPersonByUsername(
		@RequestParam("username") String username)
		throws IllegalArgumentException {
		
		return null;
	}
	
}

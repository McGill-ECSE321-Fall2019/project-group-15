package ca.mcgill.ecse321.tutoringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		@PathVariable("personID") Integer personID,
		@PathVariable("firstName") String firstName,
		@PathVariable("lastName") String lastName,
		@PathVariable("userName") String userName ) 
		throws IllegalArgumentException {
		Person person = personService.createPerson(personID, firstName, lastName, userName);
		return DtoConverters.convertToDto(person);
	}
	
}

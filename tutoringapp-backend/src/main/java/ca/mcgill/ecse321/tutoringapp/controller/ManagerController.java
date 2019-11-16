package ca.mcgill.ecse321.tutoringapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dto.ManagerDto;
import ca.mcgill.ecse321.tutoringapp.service.ManagerService;
import ca.mcgill.ecse321.tutoringapp.service.PersonService;

@CrossOrigin(origins = "*")
@RestController
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	@Autowired 
	PersonService personService;
	
	@PostMapping(value = { "/createManager", "/createManager/" })
	public ManagerDto createManager(@RequestParam(name = "password") String password, @RequestParam(name = "userName") String userName, @RequestParam(name = "managerId") Integer managerId) throws IllegalArgumentException {
		Person person = personService.getPersonByUsername(userName);
		if (person == null) {
			throw new IllegalArgumentException("This person does not exist");
		}
		
		try {
			Manager manager = managerService.createManager(password, person, managerId);
			return DtoConverters.convertToDto(manager);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid info");
		}
	}
	
}

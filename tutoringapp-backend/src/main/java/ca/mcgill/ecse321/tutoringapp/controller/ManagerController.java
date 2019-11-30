package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dto.ManagerDto;
import ca.mcgill.ecse321.tutoringapp.dto.TutorDto;
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
	public ManagerDto createManager(@RequestParam(name = "password") String password, @RequestParam(name = "userName") String userName) throws IllegalArgumentException {
		Person person = personService.getPersonByUsername(userName);
		if (person == null) {
			throw new IllegalArgumentException("This person does not exist");
		}
		
		try {
			Manager manager = managerService.createManager(password, person);
			person.personRole.add(manager);
			return DtoConverters.convertToDto(manager);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid info");
		}
	}
	@GetMapping(value = { "/getAllManagers", "/getAllManagers/" })
	public List<ManagerDto> getAllManagers() throws IllegalArgumentException {
		List<ManagerDto> managersDto = new ArrayList<>();
		List<Manager> allManagers = managerService.getAllManagers();
		if (allManagers.size() == 0) {
			throw new IllegalArgumentException("There are no tutors");
		}
		try {
			for (Manager manager : allManagers) {
				managersDto.add(DtoConverters.convertToDto(manager));
			}
			
			return managersDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid info");
		}
	}
}

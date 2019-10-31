package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dto.TutorDto;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;

@CrossOrigin(origins = "*")
@RestController
public class TutorController {

	@Autowired
	TutorService tutorService;
	
	@PostMapping(value = {"/createTutor/", "/createTutor/"})
	public TutorDto createTutor (
		@RequestParam("tutorID") Integer tutorID,
		@RequestParam("hourlyRate") Float hourlyRate,
		@RequestParam("isVerified") Boolean isVerified,
		@RequestParam("password") String password,
		@RequestParam("person") Person person) 
		throws IllegalArgumentException {
		Tutor tutor = tutorService.createTutor(tutorID, hourlyRate, isVerified, password, person);
		return DtoConverters.convertToDto(tutor);
	}
	
	@GetMapping(value = {"/getAllTutors/","/getAllTutors/"})
	public List<TutorDto> getAllTutor() {
		
		List<TutorDto> tutorsDto = new ArrayList<>();
		List<Tutor> allTutors = tutorService.getAllTutors();
		
		for (Tutor tutor : allTutors) {
			tutorsDto.add(DtoConverters.convertToDto(tutor));
		}
		
		return tutorsDto;
	}
	
	@GetMapping(value = {"/getAllUnverifiedTutors/","/getAllUnverifiedTutors/"})
	public List<TutorDto> getAllUnverifiedTutors () {
		
		List<TutorDto> tutorsDto = new ArrayList<>();
		List<Tutor> allTutors = tutorService.getAllTutors();
		
		for (Tutor tutor : allTutors) {
			if(!tutor.isIsVerified()) {
				tutorsDto.add(DtoConverters.convertToDto(tutor));
			}
		}
		
		return tutorsDto;
	}
	
	@GetMapping(value = {"/approveTutor/","/approveTutor/"})
	public void approveTutor(
		@RequestParam("tutorID") Integer tutorID)
		throws IllegalArgumentException {
		
		Tutor tutor = tutorService.getTutor(tutorID);
		
		tutor.setIsVerified(true);
	}
	
	
}

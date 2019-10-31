package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dto.TutorDto;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;

@CrossOrigin(origins = "*")
@RestController
public class TutorController {

	@Autowired
	TutorService tutorService;
	
	@PostMapping(value = {"/addTutor/", "/addTutor"})
	public TutorDto addTutor (
		@RequestParam("tutorID") Integer tutorID,
		@RequestParam("hourlyRate") Float hourlyRate,
		@RequestParam("isVerified") Boolean isVerified,
		@RequestParam("password") String password ) 
		throws IllegalArgumentException {
		Tutor tutor = tutorService.addTutor(tutorID);
		return DtoConverters.convertToDto(tutor);
	}
	
}

package ca.mcgill.ecse321.tutoringapp.controller;


import ca.mcgill.ecse321.tutoringapp.dto.*;
import ca.mcgill.ecse321.tutoringapp.service.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ca.mcgill.ecse321.tutoringapp.dto.TutorDto;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;
import org.springframework.web.bind.annotation.*;
import ca.mcgill.ecse321.tutoringapp.Database.src.*;

@CrossOrigin(origins = "*")
@RestController
public class TutorController {

	@Autowired
	TutorService tutorService;
	@Autowired
	PersonService personService;
	
	@PostMapping(value = {"/createTutor/", "/createTutor/"})
	public TutorDto createTutor (
		@RequestParam("tutorID") Integer tutorID,
		@RequestParam("hourlyRate") Float hourlyRate,
		@RequestParam("password") String password,
		@RequestParam("userName") String userName)
		throws IllegalArgumentException {
		
		Person person = personService.getPersonByUsername(userName);
		if (person == null) {
			throw new IllegalArgumentException("This person does not exist");
		}
		try {
			Tutor tutor = tutorService.createTutor(hourlyRate, password, person, tutorID);
			personService.addPersonRole(person, tutor);
			return DtoConverters.convertToDto(tutor);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
	}
	
	@GetMapping(value = {"/getAllTutors/","/getAllTutors/"})
	public List<TutorDto> getAllTutor() throws IllegalArgumentException {
		
		List<TutorDto> tutorsDto = new ArrayList<>();
		List<Tutor> allTutors = tutorService.getAllTutors();
		if (allTutors.size() == 0) {
			throw new IllegalArgumentException("There are no tutors");
		}
		try {
			for (Tutor tutor : allTutors) {
				tutorsDto.add(DtoConverters.convertToDto(tutor));
			}
			
			return tutorsDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid info");
		}
		
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
	
	@PostMapping(value = {"/approveTutor/","/approveTutor/"})
	public void approveTutor(
		@RequestParam("tutorID") Integer tutorID)
		throws IllegalArgumentException {
		Tutor tutor = tutorService.getTutor(tutorID);
		if (tutor == null) {
			throw new IllegalArgumentException("The tutor does not exist");
		}
		try {
			tutorService.approveTutor(tutorID);
			}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
		
		
	}

	
	/**
	 * delete/fire a tutor from the service
	 * @param tutorId
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/deleteTutor", "/deleteTutor/" })
	public boolean deleteTutor(@RequestParam("tutorId") int tutorId) throws IllegalArgumentException {
		tutorService.removeTutor(tutorId);
		return true; 

	}
	/**
	 * Get a tutor with the id
	 * @param tutorId
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/tutor", "/tutor/" })
	public TutorDto getTutor(@RequestParam("tutorId")int tutorId) throws IllegalArgumentException {
		try {
			Tutor tutor = tutorService.getTutor(tutorId);
			return DtoConverters.convertToDto(tutor);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}	
	
	/**
	 * Get a list of all current tutors in the system
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/allTutors", "/allTutors/" })
	public List<TutorDto> getAllTutors() throws IllegalArgumentException {
		List<Tutor> tutorList = tutorService.getAllTutors();
		List<TutorDto> tDtio = new ArrayList<>();
		for (Tutor t : tutorList) {
			tDtio.add(DtoConverters.convertToDto(t));
		}
		return tDtio;

	}
	/**
	 * Get the list of removed Tutors from the system
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = { "/removedTutors", "/removedTutors/" })
	public List<TutorDto> getRemovedTutors() throws IllegalArgumentException {
			List<Tutor> tutorList = tutorService.getRemovedTutors();
			List<TutorDto> tDtio = new ArrayList<>();
			for (Tutor t : tutorList) {
				tDtio.add(DtoConverters.convertToDto(t));
			}
			return tDtio;

	}

}

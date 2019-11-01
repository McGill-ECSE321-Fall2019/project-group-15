package ca.mcgill.ecse321.tutoringapp.controller;

import ca.mcgill.ecse321.tutoringapp.dto.*;
import ca.mcgill.ecse321.tutoringapp.service.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ca.mcgill.ecse321.tutoringapp.Database.src.*;

@CrossOrigin(origins = "*")
@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping(value = { "/addSubject", "/addSubject/" })
	public SubjectDto addSubject(@RequestParam("subjectName") String subjectName,
			@RequestParam("schoolName") String schoolName,@RequestParam("subjectDescription") String subjectDescription)
			throws IllegalArgumentException {
		School subjectSchool = schoolService.getSchool(schoolName);
		Subject subject = subjectService.addSubject(subjectName, subjectSchool, subjectDescription);
		return DtoConverters.convertToDto(subject);
	}
	
	@GetMapping(value = { "/allSubjects", "/allSubjects/" })
	public List<SubjectDto> getAllSubjects() {
		try {
			List<SubjectDto> subjectDto = new ArrayList<>();
			for (Subject subject : subjectService.getAllSubject()) {
				subjectDto.add(DtoConverters.convertToDto(subject));
			}
			return subjectDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}
	
	@PostMapping(value = { "/deleteSubject", "/deleteCourse/" })
	public boolean deleteSubject(@RequestParam(name = "subjectName") String subjectName) {
		subjectService.removeSubject(subjectName);
		return true;
	}

}

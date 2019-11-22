package ca.mcgill.ecse321.tutoringapp.controller;

import ca.mcgill.ecse321.tutoringapp.dto.*;
import ca.mcgill.ecse321.tutoringapp.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ca.mcgill.ecse321.tutoringapp.Database.src.*;

@CrossOrigin(origins = "*")
@RestController
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping(value = { "/addSchool", "/addSchool/" })
	public SchoolDto addSchool(@RequestParam("schoolName") String schoolName,
			@RequestParam("schoolType") String schoolType) throws IllegalArgumentException {
		try{
			
			SchoolType type = SchoolType.valueOf(schoolType);
			School school = schoolService.addSchool(schoolName,type);
			return DtoConverters.convertToDto(school);
		}
		catch(Exception e){
			throw new IllegalArgumentException("Could not create school");
		}
	}
	
	@GetMapping(value = { "/allSchools", "/allSchools/" })
	public List<SchoolDto> getAllSchools() {
		try {
			List<SchoolDto> schoolDto = new ArrayList<>();
			for (School school : schoolService.getAllSchool()) {
				schoolDto.add(DtoConverters.convertToDto(school));
			}
			return schoolDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}
	
	@PostMapping(value = { "/deleteSchool", "/deleteSchool/" })
	public boolean deleteSchool(@RequestParam(name = "schoolName") String schoolName) {
		schoolService.removeSchool(schoolName);
		return true;
	}
	

}

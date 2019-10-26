package ca.mcgill.ecse321.tutoringapp.controller;

import ca.mcgill.ecse321.tutoringapp.dto.*;
import ca.mcgill.ecse321.tutoringapp.Database.src.*;
import ca.mcgill.ecse321.tutoringapp.service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DtoConverters {
	
	public static CourseDto convertToDto(Course c) {
		
		CheckArg(c);
		Set<Tutor> tutors= new HashSet<Tutor>();
        for (Tutor t : c.getTutor())
            tutors.add(new Tutor());
        return new CourseDto(c.getName(), c.getDescription(), tutors);
		
//		if(c==null) {
//			throw new IllegalArgumentException("There is no such course!");
//		}
//		CourseDto courseDto = new CourseDto(c.getName(),c.getDescription());
//		return courseDto;
		
	}        

	static void CheckArg(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Trying to convert using a null " + o.getClass().getSimpleName());
        }
    }

}

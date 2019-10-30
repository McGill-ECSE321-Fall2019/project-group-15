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
	
<<<<<<< HEAD

=======
>>>>>>> 74b0c8e89d75fd390fa27b177d8ed1ebd6e14a20
	public static SubjectDto convertToDto(Subject s) {
		
		CheckArg(s);
		
		if(s==null) {
			throw new IllegalArgumentException("There is no such subject!");
		}
		SubjectDto subjectDto = new SubjectDto(s.getName(),s.getSchool(),s.getDescription());
		return subjectDto;
		
	}        
	
	public static SchoolDto convertToDto(School sc) {
		
		CheckArg(sc);
		Set<Subject> subjects= new HashSet<Subject>();
        for (Subject s : sc.getSubject())
            subjects.add(new Subject());
        return new SchoolDto(sc.getName(), sc.getType(), subjects);
		
	}        
<<<<<<< HEAD

=======
>>>>>>> 74b0c8e89d75fd390fa27b177d8ed1ebd6e14a20
    public static StudentDto convertToDto(Student student) {
    	CheckArg(student);
    	
    	StudentDto s = new StudentDto(student.getPassword(), student.getPerson());
    	return s;
    }
    
    public static TutorDto convertToDto(Tutor tutor) {
    	CheckArg(tutor);
    	
    	TutorDto t = new TutorDto(tutor.getPassword(), tutor.getPerson());
    	return t;
    }
<<<<<<< HEAD

=======
>>>>>>> 74b0c8e89d75fd390fa27b177d8ed1ebd6e14a20

	static void CheckArg(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Trying to convert using a null " + o.getClass().getSimpleName());
        }
    }

}

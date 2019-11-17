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
		
//		CheckArg(c);
//		ArrayList<Integer> TutorIds = new ArrayList<Integer>();
//        for (Tutor t : c.getTutor())
//            TutorIds.add(t.getTutorId());
//        CourseDto courseDto = new CourseDto(c.getName(), c.getDescription(), TutorIds);
//        return courseDto;
        
		if(c==null) {
			throw new IllegalArgumentException("There is no such course!");
		}
		CourseDto courseDto = new CourseDto(c.getName(),c.getDescription());
		return courseDto;

	}        
	


	public static PersonDto convertToDto(Person p) {
		
		CheckArg(p); 
        PersonDto p1 = new PersonDto( p.getFirstName(), p.getLastName(), p.getUserName());
        return p1;
    }
	
	/*public static PersonRoleDto convertToDto (PersonRole r) {
		CheckArg(r);
		return new PersonRoleDto(r.getRoleID(), r.getPassword(), convertToDto(r.getPerson()));
	} */     


	public static SubjectDto convertToDto(Subject s) {
		
		CheckArg(s);
		
		SubjectDto subjectDto = new SubjectDto(s.getName(),s.getSchool(),s.getDescription());
		return subjectDto;
		
	}        
	
	public static SchoolDto convertToDto(School sc) {
		
		CheckArg(sc);
		
		SchoolDto schoolDto = new SchoolDto(sc.getName(),sc.getType());
		return schoolDto;
		
//		CheckArg(sc);
//		Set<Subject> subjects= new HashSet<Subject>();
//        for (Subject s : sc.getSubject())
//            subjects.add(new Subject());
//        return new SchoolDto(sc.getName(), sc.getType(), subjects);
		
	}        



    public static StudentDto convertToDto(Student student) {
    	CheckArg(student);
    	
    	StudentDto s = new StudentDto(student.getPassword(), convertToDto(student.getPerson()), student.getStudentId());
    	return s;
    }
    
    public static TutorDto convertToDto(Tutor tutor) {
    	CheckArg(tutor);
    	TutorDto t = new TutorDto(tutor.getTutorId(), tutor.getHourlyRate(), tutor.isIsVerified(), tutor.getPassword(), convertToDto(tutor.getPerson()));
    	return t;
    }

    public static EvaluationDto convertToDto(Evaluation evaluation) {
      CheckArg(evaluation);
      
      EvaluationDto e = new EvaluationDto(evaluation.getComment(), evaluation.getRating(), evaluation.getType(), DtoConverters.convertToDto(evaluation.getStudent()), evaluation.isIsFlagged(), evaluation.getEvaluationID());
      return e ;
    }
    
    public static RoomDto convertToDto(Room room) {
    	CheckArg(room);
    	
    	RoomDto r = new RoomDto(room.getName(), room.getType());
    	return r;
    }
    
    public static SessionDto convertToDto(Session session, Course course) {
    	CheckArg(session);
    	
    	CourseDto courseDto = new CourseDto(course.getName());
    	SessionDto s = new SessionDto(session.getDate(), session.getStartTime(), session.getEndTime(), session.getType(), courseDto);
    	return s;
    }
    
    public static ManagerDto convertToDto(Manager manager) {
    	CheckArg(manager);
    	
    	ManagerDto m = new ManagerDto(manager.getManagerId());
    	return m;
    }

	
	
	static void CheckArg(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Trying to convert using a null " + o.getClass().getSimpleName());
        }
	}

}

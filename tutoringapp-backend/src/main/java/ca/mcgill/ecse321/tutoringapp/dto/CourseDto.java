package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.Set;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public class CourseDto {

	private String description;
    private String courseName;
    private Set<Tutor> tutor;
    
    public CourseDto() {
    	
    }
    
    public CourseDto(String courseName) {
    	this(null, courseName);
    }
    
    public CourseDto(String description, String courseName) {
    	this.courseName = courseName;
    	this.description=description;
    }
    
    public CourseDto(String description, String courseName,Set<Tutor> tutor ) {
    	this.courseName = courseName;
    	this.description=description;
    	this.tutor=tutor;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public Set<Tutor> getTutor() {
    	return tutor;
    }
    
    public void setTutor(Set<Tutor> t) {
    	this.tutor=t;
    }
    
    public void addTutor(Tutor t) {
    	this.tutor.add(t);
    }
    
}

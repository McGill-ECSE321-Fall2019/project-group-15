package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.ArrayList;
import java.util.Set;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public class CourseDto {

	private String description;
    private String courseName;
    private ArrayList<Integer> tutorIds;
    
    public CourseDto() {
    	
    }
    
    public CourseDto(String courseName) {
    	this(null, courseName);
    }
    
    public CourseDto(String description, String courseName) {
    	this.courseName = courseName;
    	this.description=description;
    }
    
    public CourseDto(String description, String courseName,ArrayList<Integer> tutorIds ) {
    	this.courseName = courseName;
    	this.description=description;
    	this.tutorIds=tutorIds;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public String getDescription() {
    	return description;
    }
    
    public ArrayList<Integer> getTutorId() {
		return this.tutorIds;
	}
    
    
}

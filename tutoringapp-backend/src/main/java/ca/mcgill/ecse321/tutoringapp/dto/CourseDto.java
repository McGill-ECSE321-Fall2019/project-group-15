package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.ArrayList;
import java.util.Set;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public class CourseDto {

	private String description;
    private String courseName;
    
    
    public CourseDto() {
    	
    }
    
    public CourseDto(String courseName) {
    	this(null, courseName);
    }
    
    public CourseDto(String description, String courseName) {
    	this.courseName = courseName;
    	this.description=description;
    }
    
    
    public String getCourseName() {
        return courseName;
    }
    
    public String getDescription() {
    	return description;
    }
    
    
    
    
}

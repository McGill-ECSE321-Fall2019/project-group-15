package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.ArrayList;
import java.util.Set;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public class CourseDto {
	
	private String courseName;
	private String description;
    
    
    
    public CourseDto() {
    	
    }
    
    public CourseDto(String courseName) {
    	this(courseName, null);
    }
    
    public CourseDto(String courseName, String description) {
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

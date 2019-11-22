package ca.mcgill.ecse321.tutoringapp.dto;

import ca.mcgill.ecse321.tutoringapp.Database.src.School;

public class SubjectDto {
	
	private String subjectName;
	private School subjectSchool;
	private String subjectDescription;
	
	public SubjectDto() {
		
	}
	
	public SubjectDto(String subjectName) {
		this.subjectName= subjectName;
		
	}
	
	public SubjectDto(String subjectName, School subjectSchool) {
		this.subjectName= subjectName;
		this.subjectSchool= subjectSchool;
		
	}
	
	public SubjectDto(String subjectName, School subjectSchool, String subjectDescription) {
		this.subjectName= subjectName;
		this.subjectSchool= subjectSchool;
		this.subjectDescription= subjectDescription;
		
	}
	
	public String getSubjectName() {
		return subjectName;
	}
	
	public School getSubjectSchool() {
		return subjectSchool;
	}
	
	public String getSubjectDescriotion() {
		return subjectDescription;
	}
	

}

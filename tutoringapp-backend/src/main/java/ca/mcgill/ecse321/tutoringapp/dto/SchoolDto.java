package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.Set;

import ca.mcgill.ecse321.tutoringapp.Database.src.SchoolType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public class SchoolDto {
	
	private String schoolName;
	private SchoolType schoolType;
	private Set<Subject> subject;
	
	public SchoolDto() {
		
	}
	
	public SchoolDto(String schoolName) {
		this.schoolName=schoolName;
	}
	
	public SchoolDto(String schoolName, SchoolType schoolType) {
		this.schoolName=schoolName;
		this.schoolType=schoolType;
	}
	
	public SchoolDto(String schoolName, SchoolType schoolType, Set<Subject> subject) {
		this.schoolName=schoolName;
		this.schoolType=schoolType;
		this.subject=subject;
	}
	
	public String getSchoolName() {
		return schoolName;
	}
	
	public SchoolType getSchoolType() {
		return schoolType;
	}
	
	public Set<Subject> getSubject() {
    	return subject;
    }
	
	public void setSubject(Set<Subject> s) {
    	this.subject=s;
    }
	
	public void addSubject(Subject s) {
    	this.subject.add(s);
    }
}

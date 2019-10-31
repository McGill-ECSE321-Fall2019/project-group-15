package ca.mcgill.ecse321.tutoringapp.dto;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public class TutorDto {



	private Integer tutorID;
	private Float hourlyRate;
	private Boolean isVerified;
	//Inherited from PersonRoleDto
	private String password;
	private PersonDto person;
	
	public TutorDto() {	
	}
	
	public TutorDto(String password, PersonDto person) {
		this.password = password;
		this.person = person;
	}
	
	public TutorDto(Integer tutorID) {
		this(tutorID, null, false, null, null);
	}
	
	public TutorDto(Integer tutorID, String password, PersonDto person) {
		this(tutorID, null, false, password, person);
	}
	
	public TutorDto(Integer tutorID, Float hourlyRate, Boolean isVerified, String password, PersonDto person) {
		this.tutorID = tutorID;
		this.hourlyRate = hourlyRate;
		this.isVerified = isVerified;
		this.password = password;
		this.person = person;
	}
	
	public int getID() {
		return tutorID;
	}
	
	public Integer getTutorID() {
		return tutorID;
	}
	
	public Float getHourlyRate() {
		return hourlyRate;
	}
	
	public Boolean getIsVerified() {
		return isVerified;
	}
	
	public String getPassword() {
		return password;
	}
	
	public PersonDto getPerson() {
		return person;
	}
	
	public void setTutorID(Integer tutorID) {
		this.tutorID = tutorID;
	}
	
	public void setHourlyRate(Float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPerson(PersonDto person) {
		this.person = person;
	}
	
}

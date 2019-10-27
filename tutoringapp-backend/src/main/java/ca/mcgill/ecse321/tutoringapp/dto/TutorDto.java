package ca.mcgill.ecse321.tutoringapp.dto;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public class TutorDto {
	private int id;
	
	private String password;
	private Person person;
	public TutorDto() {
		
	}
	
	public TutorDto(String password, Person person) {
		this.password = password;
		this.person = person;
	}
	
	public int getID() {
		return id;
	}

}

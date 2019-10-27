package ca.mcgill.ecse321.tutoringapp.dto;

public class TutorDto {

	private Float hourlyRate;
	private Boolean isVerified;
	//Inherited from PersonRoleDto
	private String password;
	private PersonDto person;
	
	public TutorDto(Float hourlyRate) {
		this(hourlyRate, false, null);
	}
	
	public TutorDto(Float hourlyRate, Boolean isVerified, PersonDto person) {
		this.hourlyRate = hourlyRate;
		this.isVerified = isVerified;
		this.person = person;
	}
	
	public Float getHourlyRate() {
		return hourlyRate;
	}
	
	public Boolean getIsVerified() {
		return isVerified;
	}
	
	public PersonDto getPerson() {
		return person;
	}
	
	public void setPerson(PersonDto person) {
		this.person = person;
	}
	
}

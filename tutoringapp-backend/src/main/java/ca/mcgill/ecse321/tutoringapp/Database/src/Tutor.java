package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.Set;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Tutor")
public class Tutor extends PersonRole{
	private Set<Course> course;

	@ManyToMany(mappedBy="tutor")
	public Set<Course> getCourse() {
		return this.course;
	}

	public void setCourse(Set<Course> courses) {
		this.course = courses;
	}

	private float hourlyRate;

	public void setHourlyRate(float value) {
		this.hourlyRate = value;
	}
	public float getHourlyRate() {
		return this.hourlyRate;
	}
	private Set<Session> session;

	@OneToMany(mappedBy="tutor" )
	public Set<Session> getSession() {
		return this.session;
	}

	public void setSession(Set<Session> sessions) {
		this.session = sessions;
	}

	private int tutorID;

	public void setTutorID(int value) {
		this.tutorID = value;
	}
	//@Id
	public int getTutorID() {
		return this.tutorID;
	}

	private boolean isVerified;

	public void setIsVerified(boolean value) {
		this.isVerified = value;
	}
	public boolean isIsVerified() {
		return this.isVerified;
	}

}

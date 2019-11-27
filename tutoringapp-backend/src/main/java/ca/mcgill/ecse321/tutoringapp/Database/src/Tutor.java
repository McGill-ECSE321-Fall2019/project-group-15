package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import javax.persistence.ManyToMany;

@Entity
public class Tutor extends PersonRole{
	
	private Integer tutorId;
	   
	   public void setTutorId(int value) {
	      this.tutorId = value;
	   }
	   @Id
	   public Integer getTutorId() {
	      return this.tutorId;
	   }
	
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

	private boolean isVerified;

	public void setIsVerified(boolean value) {
		this.isVerified = value;
	}
	public boolean isIsVerified() {
		return this.isVerified;
	}
	private Set<Evaluation> evaluation;

	@OneToMany(mappedBy="tutor" )
	public Set<Evaluation> getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Set<Evaluation> evaluations) {
		this.evaluation = evaluations;
	}

}

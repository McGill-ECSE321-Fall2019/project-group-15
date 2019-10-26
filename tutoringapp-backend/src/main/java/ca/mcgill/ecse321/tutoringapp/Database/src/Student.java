package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Id;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Student")
public class Student extends PersonRole{
	private Set<Session> session;

	@ManyToMany(mappedBy="student" )
	public Set<Session> getSession() {
		return this.session;
	}

	public void setSession(Set<Session> sessions) {
		this.session = sessions;
	}

	private Set<Evaluation> evaluation;

	@OneToMany(mappedBy="student" )
	public Set<Evaluation> getEvaluation() {
		return this.evaluation;
	}

	public void setEvaluation(Set<Evaluation> evaluations) {
		this.evaluation = evaluations;
	}
	/*private int studentID;

	public void setStudentID(int value) {
		this.studentID = value;
	}

	public int getStudentID() {
		return this.studentID;
	}*/
}

package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Student extends PersonRole{
	@Id
	private int studentId;
	   
	   public void setStudentId(int value) {
	      this.studentId = value;
	   }
	   
	   public int getStudentId() {
	      return this.studentId;
	   }
	   
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
}

package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Manager extends PersonRole{
	
	private Integer managerId;
	
	public void setManagerId(int value) {
		this.managerId = value;
	}
	//@Id
	public Integer getManagerId() {
		return this.managerId;
	}
	
	private Set<Evaluation> evaluation;
   
   @OneToMany(mappedBy="manager" )
   public Set<Evaluation> getEvaluation() {
      return this.evaluation;
   }
   
   public void setEvaluation(Set<Evaluation> evaluations) {
      this.evaluation = evaluations;
   }
   
   private Set<Session> session;
   
   @OneToMany(mappedBy="manager" )
   public Set<Session> getSession() {
      return this.session;
   }
   
   public void setSession(Set<Session> sessions) {
      this.session = sessions;
   }
   
   }

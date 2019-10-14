package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.OneToMany;

@Entity
public class Manager extends PersonRole{
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

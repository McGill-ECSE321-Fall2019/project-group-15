import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Evaluation{
   private int rating;
   
   public void setRating(int value) {
      this.rating = value;
   }
   
   public int getRating() {
      return this.rating;
   }
   
   private String comment;
   
   public void setComment(String value) {
      this.comment = value;
   }
   
   public String getComment() {
      return this.comment;
   }
   
   private Student student;
   
   @ManyToOne(optional=false)
   public Student getStudent() {
      return this.student;
   }
   
   public void setStudent(Student student) {
      this.student = student;
   }
   
   private Manager manager;
   
   @ManyToOne(optional=false)
   public Manager getManager() {
      return this.manager;
   }
   
   public void setManager(Manager manager) {
      this.manager = manager;
   }
   
   private boolean isFlagged;
   
   public void setIsFlagged(boolean value) {
      this.isFlagged = value;
   }
   
   public boolean isIsFlagged() {
      return this.isFlagged;
   }
   
   private int evaluationID;
   
   public void setEvaluationID(int value) {
      this.evaluationID = value;
   }
   
   public int getEvaluationID() {
      return this.evaluationID;
   }
   
   /**
    * <pre>
    *           1..1     1..1
    * Evaluation ------------------------> EvaluationType
    *           &lt;       type
    * </pre>
    */
   private EvaluationType type;
   
   public void setType(EvaluationType value) {
      this.type = value;
   }
   
   public EvaluationType getType() {
      return this.type;
   }
   
   }

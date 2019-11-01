package ca.mcgill.ecse321.tutoringapp.dto;

import java.sql.Date;
import java.sql.Time;

public class EvaluationDto {

  private String comment;
  private int id;
  private int rating;
  private StudentDto student;
  private TutorDto tutor;
  
  
  public EvaluationDto(int id,  String comment, int rating) {
    this.id = id;
    this.comment = comment;
    this.rating = rating;
  }
  
  public EvaluationDto( String comment, int rating) {
    this.comment = comment;
    this.rating = rating;
  }
  public int getID() {
    return id;
}
  
  public String getComment() {
  return comment;
}
  public int getRating() {
  return rating;
}


}

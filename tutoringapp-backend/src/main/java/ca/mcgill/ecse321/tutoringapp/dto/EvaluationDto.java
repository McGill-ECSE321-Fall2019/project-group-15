package ca.mcgill.ecse321.tutoringapp.dto;

import java.sql.Date;
import java.sql.Time;

public class EvaluationDto {

  private String comment;
  private int id;
  private int rating;
  private StudentDto student;
  private TutorDto tutor;
  
  public EvaluationDto() {
  }
  
  
  public EvaluationDto(int id) {
    this.id = id;
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

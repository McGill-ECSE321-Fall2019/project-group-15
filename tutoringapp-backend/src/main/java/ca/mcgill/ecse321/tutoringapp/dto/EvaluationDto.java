package ca.mcgill.ecse321.tutoringapp.dto;

import java.sql.Date;
import java.sql.Time;

import ca.mcgill.ecse321.tutoringapp.Database.src.EvaluationType;

public class EvaluationDto {

  private String comment;
  private int rating;
  private EvaluationType type;
  private boolean isFlagged;
  private StudentDto student;
  private TutorDto tutor;
  private int id;
  
  
  public EvaluationDto(String comment, int rating, EvaluationType type, StudentDto student, boolean flagged, int id) {
    this.comment = comment;
    this.rating = rating;
    this.type = type;
    this.student = student;
    this.isFlagged = flagged;
    this.id = id;
  }
  
  public EvaluationDto( String comment, int rating) {
    this.comment = comment;
    this.rating = rating;
  }

public String getComment() {
	return comment;
}

public void setComment(String comment) {
	this.comment = comment;
}

public int getRating() {
	return rating;
}

public void setRating(int rating) {
	this.rating = rating;
}

public EvaluationType getType() {
	return type;
}

public void setType(EvaluationType type) {
	this.type = type;
}

public StudentDto getStudent() {
	return student;
}

public void setStudent(StudentDto student) {
	this.student = student;
}

public TutorDto getTutor() {
	return tutor;
}

public void setTutor(TutorDto tutor) {
	this.tutor = tutor;
}

public boolean isFlagged() {
	return isFlagged;
}

public void setFlagged(boolean isFlagged) {
	this.isFlagged = isFlagged;
}



}

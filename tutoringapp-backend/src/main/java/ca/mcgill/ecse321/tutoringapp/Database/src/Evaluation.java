package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import javax.persistence.Id;

@Entity
public class Evaluation{
	private int rating;

	private EvaluationType type;


	public void setType(EvaluationType value) {
		this.type = value;
	}
	public EvaluationType getType() {
		return this.type;
	}

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
	@Id
	public int getEvaluationID() {
		return this.evaluationID;
	}
}

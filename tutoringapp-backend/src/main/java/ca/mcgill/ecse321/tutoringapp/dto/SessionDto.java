package ca.mcgill.ecse321.tutoringapp.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Set;

import ca.mcgill.ecse321.tutoringapp.Database.src.SessionType;

public class SessionDto {
	
	private Date date;
	private Time startTime;
	private Time endTime;
	private SessionType type;
	private Set<StudentDto> students;
	private TutorDto tutor;
	private CourseDto course;
	
	public SessionDto(Date date, Time startTime, Time endTime, SessionType type, CourseDto course) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.course = course;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getStartTime() {
		return startTime;
	}

	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}

	public Time getEndTime() {
		return endTime;
	}

	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}

	public SessionType getType() {
		return type;
	}

	public void setType(SessionType type) {
		this.type = type;
	}

	public TutorDto getTutor() {
		return tutor;
	}

	public void setTutor(TutorDto tutor) {
		this.tutor = tutor;
	}

	public CourseDto getCourse() {
		return course;
	}

	public void setCourse(CourseDto course) {
		this.course = course;
	}

	public Set<StudentDto> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentDto> students) {
		this.students = students;
	}
}

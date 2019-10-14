package ca.mcgill.ecse321.tutoringapp.Database.src;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Set;
import javax.persistence.ManyToMany;

@Entity
public class Session{
private SessionType type;

public void setType(SessionType value) {
this.type = value;
}
public SessionType getType() {
return this.type;
}
   private String date;

public void setDate(String value) {
    this.date = value;
}
public String getDate() {
    return this.date;
}
private Room room;

@ManyToOne(optional=false)
public Room getRoom() {
   return this.room;
}

public void setRoom(Room room) {
   this.room = room;
}

private Tutor tutor;

@ManyToOne(optional=false)
public Tutor getTutor() {
   return this.tutor;
}

public void setTutor(Tutor tutor) {
   this.tutor = tutor;
}

private Set<Student> student;

@ManyToMany
public Set<Student> getStudent() {
   return this.student;
}

public void setStudent(Set<Student> students) {
   this.student = students;
}

private Course course;

@ManyToOne(optional=false)
public Course getCourse() {
   return this.course;
}

public void setCourse(Course course) {
   this.course = course;
}

private Manager manager;

@ManyToOne(optional=false)
public Manager getManager() {
   return this.manager;
}

public void setManager(Manager manager) {
   this.manager = manager;
}
private String startTime;

public void setStartTime(String value) {
    this.startTime = value;
}
public String getStartTime() {
    return this.startTime;
}
private String endTime;

public void setEndTime(String value) {
    this.endTime = value;
}
public String getEndTime() {
    return this.endTime;
}
private int sessionID;

public void setSessionID(int value) {
    this.sessionID = value;
}
public int getSessionID() {
    return this.sessionID;
}
}

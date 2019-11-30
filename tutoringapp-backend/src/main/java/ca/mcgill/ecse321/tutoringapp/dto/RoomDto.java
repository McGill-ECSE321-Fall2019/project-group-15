package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.List;

import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;

public class RoomDto {
	
	private String name;
	private boolean isAvailable;
	private RoomType type;
	private List<SessionDto> sessions;
	
	public RoomDto() {
		
	}
	
	public RoomDto(String name, RoomType type) {
		this.name = name;
		this.type = type;
	}
	
	public String getRoomName() {
		return this.name;
	}
	
	public RoomType getRoomType() {
		return this.type;
	}
	
	public boolean getAvailable() {
		return this.isAvailable;
	}
	
	public List<SessionDto> getSessions() {
		return this.sessions;
	}
	
	public void setSessions(List<SessionDto> sessions) {
		this.sessions = sessions;
	}
	
	public void setAvailable(boolean value) {
		this.isAvailable = value;
	}
}

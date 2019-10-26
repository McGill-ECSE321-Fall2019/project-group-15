package ca.mcgill.ecse321.tutoringapp.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Session;
import ca.mcgill.ecse321.tutoringapp.dao.RoomRepository;

@Service
public class RoomService {

	@Autowired
	RoomRepository roomRepository;

	@Transactional
	public Room createRoom(String name, RoomType type) {
		Room room = new Room();
		room.setName(name);
		room.setType(type);
		roomRepository.save(room);
		return room;
	}
	
	@Transactional
	public Room getRoom(String name) {
		Room room = roomRepository.findRoomByName(name);
		return room;
	}
	
	@Transactional
	public List<Room> getAllRooms() {
		return toList(roomRepository.findAll());
	}
	
	@Transactional
	public List<Room> getRoomsByType(RoomType type) {
		return toList(roomRepository.findByTypeEquals(type));
	}
	
	@Transactional
	public List<Room> getAvailableLargeRoomsForDayStartEnd(Date day, Time startTime, Time endTime) {
		List<Room> available = new ArrayList<>();
		for (Room r : roomRepository.findByTypeEquals(RoomType.largeRoom)) {
			List<Session> todaySession = new ArrayList<>();
			for (Session s : r.getSession()) {
				if (s.getDate() == day) {
					todaySession.add(s);
				}
			}
			if (todaySession.size() == 0) { //If no session in room on that day, available
				available.add(r);
			}
			else {//If at least one session that day
				List<Session> unavailable = new ArrayList<>();
				for (Session s1 : todaySession) { 
					if (s1.getEndTime().after(startTime) && s1.getEndTime().before(endTime)) { //EndTime of Session in middle of session
						unavailable.add(s1);
					}
					if (s1.getStartTime().after(startTime) && s1.getStartTime().before(endTime)) { //StartTime of session in middle
						unavailable.add(s1);
					}
					if (s1.getStartTime().before(startTime) && s1.getEndTime().after(endTime)) { //StartTime before and EndTime after
						unavailable.add(s1);
					}
					if (s1.getStartTime().equals(startTime) || s1.getEndTime().equals(endTime)) { //StartTime or EndTime equal
						unavailable.add(s1);
					}
				}
				if (unavailable.size() == 0) {
					available.add(r);
				}
			}
		}
		return available;
	}
	
	@Transactional
	public void assignLargeRoomToGroupSession(Room room, Session session) {
		if (roomRepository.findRoomByName(room.getName()) == null) {
			throw new IllegalArgumentException("This room doesn't exist");
		}
		if (room.getType() != RoomType.largeRoom) {
			throw new IllegalArgumentException("Can only manually assign large rooms");
		}
		if (!(this.getAvailableLargeRoomsForDayStartEnd(session.getDate(), session.getStartTime(), session.getEndTime()).contains(room))) {
			throw new IllegalArgumentException("The room is not available for this time slot");
		}
		session.setRoom(room);
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}

package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;

public interface RoomRepository extends CrudRepository<Room, String> {
	Room findRoomByName(String name);
	List<Room> findByTypeEquals(RoomType type);
}

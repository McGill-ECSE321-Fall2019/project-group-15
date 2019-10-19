package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Room;

public interface RoomRepository extends CrudRepository<Room, Integer> {
	Room findByID(Integer ID);
}

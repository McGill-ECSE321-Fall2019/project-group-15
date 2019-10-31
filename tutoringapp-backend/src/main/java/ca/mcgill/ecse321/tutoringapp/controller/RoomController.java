package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.tutoringapp.Database.src.Room;
import ca.mcgill.ecse321.tutoringapp.Database.src.RoomType;
import ca.mcgill.ecse321.tutoringapp.dto.RoomDto;
import ca.mcgill.ecse321.tutoringapp.service.RoomService;

@CrossOrigin(origins = "*")
@RestController
public class RoomController {

	@Autowired
	RoomService roomService;

	/*
	 * Create a new room
	 */

	@PostMapping(value = { "/createRoom", "/createRoom/" })
	public RoomDto createRoom(@RequestParam(name = "roomName") String name, @RequestParam(name = "roomType") RoomType type) throws IllegalArgumentException { 
		List<Room> smallRooms = roomService.getRoomsByType(RoomType.smallRoom);
		List<Room> largeRooms = roomService.getRoomsByType(RoomType.largeRoom);

		if (!(smallRooms.size() < 10)) {
			throw new IllegalArgumentException("There are already 10 small rooms");
		}
		if (!(largeRooms.size()<3)) {
			throw new IllegalArgumentException("There are already 3 large rooms");
		}
		try {
			Room room = roomService.createRoom(name, type);
			return DtoConverters.convertToDto(room);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
	}

}

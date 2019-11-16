package ca.mcgill.ecse321.tutoringapp.controller;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

	/**
	 * Create a room
	 * 
	 * @param name
	 * @param type
	 * @return
	 * @throws IllegalArgumentException
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
	
	/**
	 * 
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @return
	 * @throws IllegalArgumentException
	 */
	
	@GetMapping(value = { "/getAvailableLargeRooms", "/getAvailableLargeRooms/" })
	public List<RoomDto> getAvailableLargeRooms(@RequestParam(name = "date") String date, @RequestParam(name = "startTime") String startTime, @RequestParam(name = "endTime") String endTime) throws IllegalArgumentException {
		List<RoomDto> availableLargeRoomsDto = new ArrayList<>();
		if (roomService.getRoomsByType(RoomType.largeRoom).size() == 0) {
			throw new IllegalArgumentException("There are no existing large rooms");
		}
		
		try {
			List<Room> largeRooms = roomService.getAvailableLargeRoomsForDayStartEnd(Date.valueOf(date), Time.valueOf(startTime), Time.valueOf(endTime));
			for (Room room : largeRooms) {
				availableLargeRoomsDto.add(DtoConverters.convertToDto(room));
			}
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
		return availableLargeRoomsDto;
	}
}

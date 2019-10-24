package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public interface TutorRepository extends CrudRepository<Tutor, Integer> {
	Tutor findTutorByTutorID(Integer ID);
	//List<Tutor> findByFirstName(String firstName);
	//List<Tutor> findByLastName (String lastName);
	List<Tutor> findByIsVerified(Boolean isVerified);
}

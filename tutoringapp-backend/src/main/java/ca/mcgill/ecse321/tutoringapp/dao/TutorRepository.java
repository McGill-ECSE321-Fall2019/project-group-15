package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;

public interface TutorRepository extends CrudRepository<Tutor, Integer> {
	Tutor findTutorByTutorID(Integer ID);
}

package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.School;

public interface SchoolRepository extends CrudRepository<School, String> {
	School findSchoolByName(String name);
	void deleteByName(String name);
}

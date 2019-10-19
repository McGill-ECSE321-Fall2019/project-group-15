package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	
	Person findPersonByName(String name);

}

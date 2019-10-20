package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	
	Person findPersonByUserName(String username);
	List<Person> findByFirstnameAndLastName(String firstname, String lastname);

}

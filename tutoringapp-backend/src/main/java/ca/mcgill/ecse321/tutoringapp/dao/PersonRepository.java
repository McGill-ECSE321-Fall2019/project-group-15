package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;

public interface PersonRepository extends CrudRepository<Person, String> {
	
	Person findPersonByUserName(String userName);
	//Person findPersonByPersonID(Integer personID);
	//List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);


}

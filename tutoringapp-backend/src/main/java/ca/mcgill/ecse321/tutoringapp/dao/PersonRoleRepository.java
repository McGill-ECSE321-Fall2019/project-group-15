package ca.mcgill.ecse321.tutoringapp.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.Database.src.PersonRole;

public interface PersonRoleRepository extends CrudRepository<PersonRole, Integer> {
	
	PersonRole findPersonRoleById(Integer ID);
	List<PersonRole> findByPerson(Person username);
}

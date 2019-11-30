package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	Manager findManagerByManagerId(Integer id);

}

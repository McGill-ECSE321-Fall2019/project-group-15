package ca.mcgill.ecse321.tutoringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Person;
import ca.mcgill.ecse321.tutoringapp.dao.ManagerRepository;

@Service
public class ManagerService {
	@Autowired
	ManagerRepository managerRepository;
	
	@Transactional
	public Manager createManager(String password, Person person, Integer managerId) {
		Manager manager = new Manager();
		manager.setPassword(password);
		manager.setPerson(person);
		manager.setEvaluation(null);
		manager.setSession(null);
		manager.setManagerId(managerId);
		managerRepository.save(manager);
		return manager;
	}
	
	@Transactional
	public Manager getManager(Integer managerId) {
		return managerRepository.findManagerByManagerId(managerId);
	}
}

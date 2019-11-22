package ca.mcgill.ecse321.tutoringapp.service;

import java.util.ArrayList;
import java.util.List;

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
	public Manager createManager(String password, Person person) {
		Manager manager = new Manager();
		manager.setPassword(password);
		manager.setPerson(person);
		manager.setEvaluation(null);
		manager.setSession(null);
		int managerID = 0;
		while(managerRepository.findManagerByManagerId(managerID) != null) {
			managerID++;
		}
		manager.setManagerId(managerID);
		managerRepository.save(manager);
		return manager;
	}
	
	@Transactional
	public Manager getManager(Integer managerId) {
		return managerRepository.findManagerByManagerId(managerId);
	}
	
	@Transactional
	public List<Manager> getAllManagers(){
		return toList(managerRepository.findAll());
	}
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
}

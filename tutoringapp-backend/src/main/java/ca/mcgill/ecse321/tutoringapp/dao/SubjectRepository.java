package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Subject;

public interface SubjectRepository extends CrudRepository<Subject, String> {
	Subject findSubjectByName(String name);
	void deleteBySubjectName(String name);
}

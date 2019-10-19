package ca.mcgill.ecse321.tutoringapp.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.tutoringapp.Database.src.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	Student findByStudentID(Integer ID);
}

package ca.mcgill.ecse321.tutoringapp.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ca.mcgill.ecse321.tutoringapp.Database.src.Course;
import ca.mcgill.ecse321.tutoringapp.Database.src.Evaluation;
import ca.mcgill.ecse321.tutoringapp.Database.src.EvaluationType;
import ca.mcgill.ecse321.tutoringapp.Database.src.Manager;
import ca.mcgill.ecse321.tutoringapp.Database.src.Student;
import ca.mcgill.ecse321.tutoringapp.Database.src.Tutor;
import ca.mcgill.ecse321.tutoringapp.dto.CourseDto;
import ca.mcgill.ecse321.tutoringapp.dto.EvaluationDto;
import ca.mcgill.ecse321.tutoringapp.service.EvaluationService;
import ca.mcgill.ecse321.tutoringapp.service.ManagerService;
import ca.mcgill.ecse321.tutoringapp.service.StudentService;
import ca.mcgill.ecse321.tutoringapp.service.TutorService;

@CrossOrigin(origins = "*")
@RestController
public class EvaluationController {

	@Autowired
	EvaluationService evalutionService;
	@Autowired
	ManagerService managerService;
	@Autowired
	StudentService studentService;
	@Autowired
	TutorService tutorService;

	/**

	 *Creating Evaluations
	 * @param comment
	 * @param rating
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/createEvaluation", "/createEvaluation/" })
	public EvaluationDto createEvaluation(@RequestParam(name ="comment") String comment, 
			@RequestParam(name ="rating") Integer rating, @RequestParam(name = "type") EvaluationType type, @RequestParam(name = "studentId") Integer studentId, @RequestParam(name = "tutorId") Integer tutorId, @RequestParam(name = "managerId") Integer managerId) throws IllegalArgumentException {
		
		if (rating <0 ) {
			throw new IllegalArgumentException("Rating needs to be between 0 and 5");
		}

		if (rating >5) {
			throw new IllegalArgumentException("Rating needs to be between 0 and 5");
		}
		Manager manager = managerService.getManager(managerId);
		if (manager==null) {
			throw new IllegalArgumentException("This manager does not exist");
		}
		Student student = studentService.getStudent(studentId);
		if (student==null) {
			throw new IllegalArgumentException("This student does not exist");
		}
		Tutor tutor = tutorService.getTutor(tutorId);
		if (tutor==null) {
			throw new IllegalArgumentException("This tutor does not exist");
		}
		try{
			Evaluation evaluation = evalutionService.createEvaluation(rating, comment, type, student, tutor, manager);
			return DtoConverters.convertToDto(evaluation);
		}
		catch(Exception e){
			throw new IllegalArgumentException("Could not create evaluation");
		}

	}
	/**

	 * Listing all evaluations
	 * @return

	 */
	@GetMapping(value = { "/allEvaluations", "/allEvaluations/" })
	public List<EvaluationDto> getAllEvaluations() {
		try {
			List<EvaluationDto> evaluationDto = new ArrayList<>();
			for (Evaluation evaluation: evalutionService.getAllEvaluations()) {
				evaluationDto.add(DtoConverters.convertToDto(evaluation));
				// courseDto.add(DtoConverters.convertToDto(course));
			}
			return evaluationDto;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Could not retrieve information from service");
		}
	}
	
	@PostMapping(value = { "/flagEvaluation", "/flagEvaluation/" })
	public EvaluationDto flagEvaluation(@RequestParam(name = "evaluationID") int ID) throws IllegalArgumentException{
		Evaluation evaluation = evalutionService.getEvaluation(ID);
		if (evaluation == null) {
			throw new IllegalArgumentException("The evaluation does not exist");
		}
		try {
			evalutionService.flagEvaluation(evaluation);
			return DtoConverters.convertToDto(evaluation);
		}
		catch(Exception e) {
			throw new IllegalArgumentException("Please enter valid information");
		}
	}
	/**
	 * Deleting Evaluation
	 * @param ID
	 * @return
	 */
	@PostMapping(value = { "/deleteEvaluation", "/deleteEvaluation/" })
	public boolean deleteEvaluation(@RequestParam(name = "ID") int ID) {
		evalutionService.removeEvaluation(ID);
		return true;
	}
}

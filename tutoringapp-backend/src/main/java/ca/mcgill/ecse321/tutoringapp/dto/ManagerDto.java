package ca.mcgill.ecse321.tutoringapp.dto;

import java.util.Set;

public class ManagerDto {
	
	private Integer managerId;
	private Set<EvaluationDto> evaluations;
	private Set<SessionDto> sessions;
	
	public ManagerDto(Integer managerId) {
		this.managerId = managerId;
	}
	
	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public Set<EvaluationDto> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(Set<EvaluationDto> evaluations) {
		this.evaluations = evaluations;
	}
	public Set<SessionDto> getSessions() {
		return sessions;
	}
	public void setSessions(Set<SessionDto> sessions) {
		this.sessions = sessions;
	}
	
}

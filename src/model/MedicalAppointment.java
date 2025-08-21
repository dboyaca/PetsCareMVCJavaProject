
package model;

import java.time.LocalDateTime;

public class MedicalAppointment {

	//Attributes
	private int idMedApp; // PK
	private int idPet; // FK
	private int idDoctor; // FK
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String state;
	
	// Attributes for the specific query we were asked by the stakeholders
	private String petName;
	private String doctor;
	private String speciality;
	
	
	//Builder
	public MedicalAppointment(int idMedApp, int idPet, int idDoctor, LocalDateTime startTime, LocalDateTime endTime, String state) {
		this.idMedApp = idMedApp;
		this.idPet = idPet;
		this.idDoctor = idDoctor;
		this.startTime = startTime;
		this.endTime = endTime; 
		this.state = state;
	}
	
	/**
	 * Builder overload
	 * This builder is constituted to retrieve a specific query required by stakeholders
	 * @return 
	 */
	public MedicalAppointment(int idMedApp, String petName, String state, String speciality) {
		this.idMedApp = idMedApp;
		this.petName = petName;
		this.state = state;
		this.speciality = speciality;
		//this.doctor = doctor;
	}
	
	//Getters and Setters
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public int getIdMedApp() {
		return idMedApp;
	}
	
	public int getIdPet() {
		return idPet;
	}
	
	public int getIdDoctor() {
		return idDoctor;
	}

	
	
	@Override
	public String toString() {
		return "Consulta Agendada [id=" + idMedApp + ", Estado=" + state + ", Nombre Paciente=" + petName
				+ ", Especialidad=" + speciality + "]";
	}

	public Object[] toArray(){
		Object[] data = {idMedApp, petName, state, speciality};
		return data;
	}
	
}

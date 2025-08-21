package view;

import model.*;
import access.MedicalAppointmentDAO;
import java.util.ArrayList;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class MainPanel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LocalDateTime initialHour = LocalDateTime.of(2025, 8, 20, 9, 30);
		LocalDateTime finalHour = LocalDateTime.of(2025, 8, 20, 10, 30);

		deleteAppointmentById(8);
		deleteAppointmentById(9);
		deleteAppointmentById(10);
		deleteAppointmentById(11);

		
		System.out.println("Obtención de todas las consultas agendadas");
		getAllAppointments();
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("Agendamiento de una cita para Rocky, inicia a las 9:30, finaliza a las 10:30, y se encuentra programada");
		scheduleAppointment(5, 3, 5, initialHour, finalHour, "Programada");
		System.out.println("Agendamiento finalizado");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("Obteniendo agendamiento de una cita por ID");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("Obtención del agendamiento recién creado a través de su id");
		getAppointmentById(5);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("Actualizando el agendamiento recién realizado");
		updateStateAppointmentById(5,"Completada");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("Obtención del agendamiento recién creado a través de su id");
		getAppointmentById(5);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		System.out.println("Eliminar citas a través de su ID");
		deleteAppointmentById(5);
		System.out.println("----------------------------------------------------------------------------------------------------------------------");
		
	}
	
	public static void getAllAppointments() {
		MedicalAppointmentDAO medicalAppointmentDAO = new MedicalAppointmentDAO();
		
		ArrayList<MedicalAppointment> appointments = new ArrayList<>();
		
		appointments = medicalAppointmentDAO.getAllAppointments();
		
		for (int i = 0; i < appointments.size(); i++) {
			System.out.println(appointments.get(i).toString());
		}
	}
	
	public static void scheduleAppointment(int id_medapp, int id_paciente, int id_especialista, LocalDateTime hora_inicio, LocalDateTime hora_fin, String estado_actual) {
		MedicalAppointmentDAO medicalAppointmentDAO = new MedicalAppointmentDAO();
		
		MedicalAppointment appointment = new MedicalAppointment(id_medapp, id_paciente, id_especialista, hora_inicio, hora_fin, estado_actual);
		
		medicalAppointmentDAO.insertAppointment(appointment);		
	}
	
	public static void getAppointmentById(int id) {
		MedicalAppointmentDAO medicalAppointmentDAO = new MedicalAppointmentDAO();
		
		MedicalAppointment appointment = medicalAppointmentDAO.getAppointmentById(id);
		
		System.out.println(appointment.toString());
		
	}
	
	public static void updateStateAppointmentById(int id, String state) {
		MedicalAppointmentDAO medicalAppointmentDAO = new MedicalAppointmentDAO();
		
		medicalAppointmentDAO.updateStateAppointmentById(id, state);
		
		System.out.println("Proceso de actualización finalizado");
		
	}
	
	public static void deleteAppointmentById(int id) {
		MedicalAppointmentDAO medicalAppointmentDAO = new MedicalAppointmentDAO();
		
		medicalAppointmentDAO.deleteAppointmentById(id);
		
		System.out.println("Proceso de actualización finalizado");
		
	}

}

package access;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import model.MedicalAppointment;
import utils.ConnectionDB;

import model.MedicalAppointment;


public class MedicalAppointmentDAO {
	
	private Connection conn = null;
	
	/**
	 * This method retrieve all the medical appointments what have been generated 
	 * @return
	 */
	public ArrayList<MedicalAppointment> getAllAppointments(){
		ArrayList<MedicalAppointment> appointments = new ArrayList();
		
		try {
			
			if(conn == null) {
				conn = ConnectionDB.getConnection();
			}
			
			String sql = "SELECT consultaagendada.id_consulta, paciente.nombre_paciente, consultaagendada.estado_actual,especialidad.nombre_especialidad\r\n"
					+ "FROM consultaagendada\r\n"
					+ "JOIN paciente ON paciente.id_paciente = consultaagendada.id_paciente\r\n"
					+ "JOIN especialidadempleado ON especialidadempleado.id_empleado = consultaagendada.id_especialista\r\n"
					+ "JOIN especialidad ON especialidad.id_especialidad = especialidadempleado.id_especialidad\r\n"
					+ "ORDER BY consultaagendada.hora_inicio;";
			
			Statement statement = conn.createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			while(result.next()) {
				MedicalAppointment appointment = new MedicalAppointment(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
				appointments.add(appointment);
			}
					
		} 
        catch (SQLException ex) 
        {
            Logger.getLogger(MedicalAppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		
		return appointments;
	}
	
	public MedicalAppointment getAppointmentById(int id) {
		
		MedicalAppointment appointment = null;
		
		try {
			
			if(conn == null) {
				conn = ConnectionDB.getConnection();
			}
			String sql =
					  "SELECT c.id_consulta, p.nombre_paciente, c.estado_actual, e.nombre_especialidad " +
					  "FROM consultaagendada c " +
					  "JOIN paciente p ON p.id_paciente = c.id_paciente " +
					  "JOIN especialidadempleado se ON se.id_empleado = c.id_especialista " +
					  "JOIN especialidad e ON e.id_especialidad = se.id_especialidad " +
					  "WHERE c.id_consulta = ? " +
					  "ORDER BY c.hora_inicio";

			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			
			while(result.next()) {
				appointment = new MedicalAppointment(result.getInt(1), result.getString(2), result.getString(3), result.getString(4));
				break;
			}
			
					
		} 
        catch (SQLException ex) 
        {
            Logger.getLogger(MedicalAppointmentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

		return appointment;
	}
	
	
	public void insertAppointment (MedicalAppointment appointment) {
		
		try {
			if(conn == null) {
				conn = ConnectionDB.getConnection();
			}
			
			String sql = "INSERT INTO consultaagendada(id_paciente, id_especialista, hora_inicio, hora_fin, estado_actual) VALUES (?,?,?,?,?) ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, appointment.getIdPet());
			statement.setInt(2, appointment.getIdDoctor() );
			statement.setTimestamp(3, Timestamp.valueOf(appointment.getStartTime()));
			statement.setTimestamp(4, Timestamp.valueOf(appointment.getEndTime()));
			statement.setString(5, appointment.getState());
			
			
			int rowsInserted = statement.executeUpdate();
			
			if(rowsInserted > 0) {
				JOptionPane.showMessageDialog(null, "El registro fue agreado exitosamente");
			}
			
					
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Código: " + ex.getErrorCode() + "\n Error: " + ex.getMessage());
		}
	}
	
	public void updateMedicalAppointment(MedicalAppointment appointment) {
		try {
			
			if(conn == null) {
				conn = ConnectionDB.getConnection();
			}
			
			String sql = "UPDATE consultaagendada SET estado_actual = ? WHERE id_consulta = ?";
			PreparedStatement statement  = conn.prepareStatement(sql);
			statement.setString(1, appointment.getState());
			statement.setInt(2, appointment.getIdMedApp());
			
			int rowsUpdated = statement.executeUpdate();
			
			if(rowsUpdated > 0 ) {
				JOptionPane.showMessageDialog(null, "El registro fue agreado exitosamente");
			}
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Código: " + ex.getErrorCode() + "\n Error: " + ex.getMessage());
		}
	}
	
	public void updateStateAppointmentById(int id, String state) {
		try {
			
			if(conn == null) {
				conn = ConnectionDB.getConnection();
			}
			
			MedicalAppointment appointment = this.getAppointmentById(id);
			
			String sql = "UPDATE consultaagendada SET estado_actual = ? WHERE id_consulta = ?";
			PreparedStatement statement  = conn.prepareStatement(sql);
			statement.setString(1, state);
			statement.setInt(2, appointment.getIdMedApp());
			
			int rowsUpdated = statement.executeUpdate();
			
			if(rowsUpdated > 0 ) {
				JOptionPane.showMessageDialog(null, "El estado de la cita fue actualizado exitosamente");
			}
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Código: " + ex.getErrorCode() + "\n Error: " + ex.getMessage());
		}
	}
	
	
	public void deleteAppointmentById(int id) {
		try {
			
			if(conn == null) {
				conn = ConnectionDB.getConnection();
			}
			
			String sql = "DELETE FROM consultaagendada WHERE id_consulta = ?";
			PreparedStatement statement  = conn.prepareStatement(sql);
			statement.setInt(1, id);

			
			int rowsUpdated = statement.executeUpdate();
			
			if(rowsUpdated > 0 ) {
				JOptionPane.showMessageDialog(null, "El registro fue eliminado exitosamente");
			}
		}
		catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Código: " + ex.getErrorCode() + "\n Error: " + ex.getMessage());
		}
	}	
	
	
	
	
	
}

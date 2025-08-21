package model;

import java.time.LocalDateTime;

public class Doctor {
	
	private int idEmployee; // This is a foreign key, it comes from users' table
	private LocalDateTime startDate;
	private double salary;
	
	
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getIdEmployee() {
		return idEmployee;
	}
	
	public LocalDateTime getStartDate() {
		return startDate;
	}
	
	@Override
	public String toString() {
		return "Doctor [idEmployee=" + idEmployee + ", startDate=" + startDate + ", salary=" + salary + "]";
	}
	
	
	
}

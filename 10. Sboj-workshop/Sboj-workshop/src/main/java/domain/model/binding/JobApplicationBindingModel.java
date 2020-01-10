package domain.model.binding;


import enums.Sector;

public class JobApplicationBindingModel {

	
	private Sector sector;
	private String profession;
	private double salary;
	private String description;
	
	
	
	
	public JobApplicationBindingModel() {
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	
	
}

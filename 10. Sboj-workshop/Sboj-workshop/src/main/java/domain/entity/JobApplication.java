package domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import enums.Sector;

@Entity
@Table(name="jobApplications")
public class JobApplication extends BaseEntity {
	
	@NotEmpty
	@Enumerated(EnumType.STRING)
	@Column()
	private Sector sector;
	
	@NotEmpty
	@Column()
	private String profession;
	
	
	@NotEmpty
	@Column()
	private double salary;
	
	@NotEmpty
	@Column()
	private String description;
	
	
	
	public JobApplication() {
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

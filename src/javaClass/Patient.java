package javaClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name ="patient")


public class Patient {
	
	
	@Id
	@Column(name = "id",updatable = false, nullable = false)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="family")
	private String family;
	
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Insurance PatientInsurance;
	
	public Insurance getPatientInsurance() {
		return PatientInsurance;
	}
	public void setPatientInsurance(Insurance PatientInsurance) {
		this.PatientInsurance =PatientInsurance;
	}
	
	
	
	@OneToMany(mappedBy = "patient") 
	private Set<PatientDrog> drogs = new HashSet<PatientDrog>();
	public Set<PatientDrog> getDrogs() {
		return drogs;
	}
	public void setDrogs(Set<PatientDrog> drogs) {
		this.drogs = drogs;
	}
	
	
	
	
	@Column
	private java.sql.Date  date;
	
	public java.sql.Date  getDate() {
		return date;
	}
	public void setDate(java.sql.Date  date) {
		this.date = date;
	}


	public Patient(int id,String name, String family,Insurance PatientInsurance ,java.sql.Date  date) {
		this.id=id;
		this.name=name;
		this.family=family;
		this.PatientInsurance=PatientInsurance;
		this.date=date;
	}
	public Patient() {
		
	}
	
	
	
	
	
	

}

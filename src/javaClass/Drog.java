package javaClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="drog")
public class Drog {
	
	
	@Id
	@Column(name="id" ,updatable = false, nullable = false)	
	private Integer id;
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
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

	
	
	@Column(name="price")
	private int price;
	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	@Column(name="Inventory")
	private int inventory;
	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}



	@OneToMany(mappedBy = "drog") 
 	private Set<DrogInsurance> insurances = new HashSet<DrogInsurance>(); 
	public Set<DrogInsurance> getInsurances() {
		return insurances;
	}


	public void setInsurances(Set<DrogInsurance> insurances) {
		this.insurances = insurances;
	}
	
	@OneToMany(mappedBy = "drog") 
 	private Set<PatientDrog> patients = new HashSet<PatientDrog>(); 
	
	
	public Set<PatientDrog> getPatients() {
		return patients;
	}


	public void setPatients(Set<PatientDrog> patients) {
		this.patients = patients;
	}
	
	
	@OneToMany(mappedBy = "drog") 
 	private Set<SaleDrug> sales = new HashSet<SaleDrug>(); 
	public Set<SaleDrug> getSales() {
		return sales;
	}


	public void setSales(Set<SaleDrug> sales) {
		this.sales = sales;
	}
	public Drog(Integer id,String name,int price,int inventory){
		this.inventory=inventory;
		this.id=id;
		this.name=name;
		this.price=price;
	}
	
	public Drog(){
		
	}
	
	public Drog(Integer id,int price){
		this.id=id;
		this.price=price;
	}
	

}

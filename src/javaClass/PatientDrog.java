package javaClass;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javaClass.DrogInsurance.DrogInsuranceId;

@Entity 
public class PatientDrog {
	@Embeddable
	public static class PatientDrogId implements Serializable{


		@Column(name = "fk_patient") 
		protected Integer patientId; 


		@Column(name = "fk_drog") 
		protected Integer drogId;


		PatientDrogId(){}


		PatientDrogId(Integer patientId,Integer drogId ){
			this.patientId=patientId;
			this.drogId=drogId;
		}

		@Override 
		public int hashCode() { 
			final int prime = 31; 
			int result = 1; 
			result = prime * result 
					+ ((patientId == null) ? 0 : patientId.hashCode()); 
			result = prime * result 
					+ ((drogId == null) ? 0 : drogId.hashCode()); 
			return result; 
		} 

		@Override 
		public boolean equals(Object obj) { 
			if (this == obj) 
				return true; 
			if (obj == null) 
				return false; 
			if (getClass() != obj.getClass()) 
				return false; 

			PatientDrogId other = (PatientDrogId) obj; 

			if (patientId == null) { 
				if (other.patientId != null) 
					return false; 
			} else if (!drogId.equals(other.patientId)) 
				return false; 

			if (patientId == null) { 
				if (other.patientId != null) 
					return false; 
			} else if (drogId.equals(other.drogId)) 
				return false; 

			return true; 
		} 
	}

	@EmbeddedId 
	private PatientDrogId id; 
	public PatientDrogId getId() {
		return id;
	}
	public void setId(PatientDrogId id) {
		this.id = id;
	}

	@ManyToOne 
	@JoinColumn(name = "fk_patient", insertable = false, updatable = false) 
	private Patient patient; 
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@ManyToOne 
	@JoinColumn(name = "fk_drog", insertable = false, updatable = false) 
	private Drog drog; 
	public Drog getDrog() {
		return drog;
	}
	public void setDrog(Drog drog) {
		this.drog = drog;
	}


	@Column
	private int share;

	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	@Column
	private int cost;

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Column
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Column
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@Column
	private Integer insuranceID;
	
	public Integer getInsuranceID() {
		return insuranceID;
	}
	public void setInsuranceID(Integer insuranceID) {
		this.insuranceID = insuranceID;
	}
	public PatientDrog( Patient p, Drog d,int quantity,Integer insuranceID, int share,int cost,String date) { 
		// create primary key 
		this.id = new PatientDrogId(p.getId(), d.getId()); 

		// initialize attributes 
		this.patient = p; 
		this.drog =d; 
		this.share = share; 
		this.cost=cost;
		this.quantity=quantity;
		this.date=date;
		this.insuranceID=insuranceID;


		// update relationships to assure referential integrity 
		p.getDrogs().add(this);
		d.getPatients().add(this); 


	}
	public PatientDrog( Patient p, Drog d,int quantity,String date) { 
		// create primary key 
		this.id = new PatientDrogId(p.getId(), d.getId()); 

		// initialize attributes 
		this.patient = p; 
		this.drog =d; 
		
		this.quantity=quantity;
		this.date=date;


		// update relationships to assure referential integrity 
		p.getDrogs().add(this);
		d.getPatients().add(this); 


	}
	public PatientDrog(){

	}


}




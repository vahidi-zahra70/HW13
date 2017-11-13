package javaClass;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.text.Format;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

@Entity 
public class SaleDrug { 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_drug", nullable = false)
	private Drog drog;
	public Drog getDrog() {
		return drog;
	}
	public void setDrog(Drog drog) {
		this.drog = drog;
	}


	
	




	@Column
	private Date date;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	@Column
	private int quantity;

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public SaleDrug( Drog b,int quantity,java.sql.Date date) { 
		
		this.drog = b; 
		this.date=date;
		this.quantity=quantity;


		
	}
	public SaleDrug(){

	}




} 


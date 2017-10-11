package javaClass;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="insurance")
public class Insurance {
	@Id
	@Column(name="id",updatable = false, nullable = false)	
	private int id;
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="type")
	private String type;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "insurance") 
 	private Set<DrogInsurance> drogs = new HashSet<DrogInsurance>(); 
	public Set<DrogInsurance> getDrogs() {
		return drogs;
	}


	public void setDrogs(Set<DrogInsurance> drogs) {
		this.drogs = drogs;
	}

	public Insurance(Integer id,String type){
		this.id=id;
		this.type=type;

	}
	public Insurance(){

	}
	
	


}

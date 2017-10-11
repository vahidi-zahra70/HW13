package javaClass;



import java.io.Serializable;
import java.text.Format;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
 public class DrogInsurance { 
 
 
 	@Embeddable 
	public static class DrogInsuranceId implements Serializable { 

 
		@Column(name = "fk_drog") 
 		protected Integer drogId; 

 
 		@Column(name = "fk_insurance") 
		protected Integer insuranceId; 
 
 
		public DrogInsuranceId() { 
			 
		} 
		 
 		public DrogInsuranceId(Integer drogId, Integer insuranceId) { 
			this.drogId = drogId; 
 			this.insuranceId = insuranceId; 
 		} 
 
 
 		@Override 
		public int hashCode() { 
 			final int prime = 31; 
 			int result = 1; 
			result = prime * result 
					+ ((drogId == null) ? 0 : drogId.hashCode()); 
			result = prime * result 
					+ ((insuranceId == null) ? 0 : insuranceId.hashCode()); 
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
 			 
 			DrogInsuranceId other = (DrogInsuranceId) obj; 
 			 
 			if (drogId == null) { 
 				if (other.drogId != null) 
 					return false; 
 			} else if (!drogId.equals(other.drogId)) 
 				return false; 
 			 
			if (insuranceId == null) { 
				if (other.insuranceId != null) 
 					return false; 
 			} else if (!insuranceId.equals(other.insuranceId)) 
 				return false; 
			 
			return true; 
		} 
 	}
 	
 	@EmbeddedId 
 		private DrogInsuranceId id; 
 	public DrogInsuranceId getId(){
 		return id;
 	}
 	
 	 
 		@ManyToOne 
 	 	@JoinColumn(name = "fk_drog", insertable = false, updatable = false) 
 	 	private Drog drog; 
 	 
 	 
 	 	@ManyToOne 
 	 	@JoinColumn(name = "fk_insurance", insertable = false, updatable = false) 
 	 	private Insurance insurance; 
 	 
 	 

 	    @Column
 	    private int share;
 	    public int getShare() {
			return share;
		}
		public void setShare(int share) {
			this.share = share;
		}
 	 
 	 	public Drog getDrog() {
			return drog;
		}
		public void setDrog(Drog drog) {
			this.drog = drog;
		}
		public Insurance getInsurance() {
			return insurance;
		}
		public void setInsurance(Insurance insurance) {
			this.insurance = insurance;
		}
		
		public DrogInsurance( Drog b, Insurance p, int share) { 
 	 		// create primary key 
 	 		this.id = new DrogInsuranceId(b.getId(), p.getId()); 
 			 
 			// initialize attributes 
 	 		this.drog = b; 
 			this.insurance = p; 
 			this.share = share; 
 	 		 
 	 		// update relationships to assure referential integrity 
 	 		p.getDrogs().add(this); 
 	 		b.getInsurances().add(this); 
 	 	}
 	 	public DrogInsurance(){
 	 		
 	 	}

 	 

	 
} 


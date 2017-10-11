package javaClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public  class User {
	
	
	@Id
	@Column(name="username" ,updatable = false, nullable = false)	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="password")
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="position")
	private String position;
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public User(String username,String password, String position){
		
		this.username=username;
		this.password=password;
		this.position=position;	
	}
	public User(){
		
	}

	
	
	
	
//	public String toString(){
//		String a="Manager[personalID="+personalID+","+"username="+username+","+"password="+password+"]";
//		return a;
//	}


}

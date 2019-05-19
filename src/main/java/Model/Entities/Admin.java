package Model.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	private String name;
	private String userA;
	private String passA;

	@OneToOne
	@JoinColumn(name = "parkId")
	private Parking parking;
	
	public Admin() {}
	
	public Admin(String name, String user, String pass)
	{
		this.name= name;
		this.userA = user;
		this.passA = pass;
	}
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUser() {
		return userA;
	}
	public void setUser(String user) {
		this.userA = user;
	}
	public String getPass() {
		return passA;
	}
	public void setPass(String pass) {
		this.passA = pass;
	}
	public Parking getParking() {
		return parking;
	}
	public void setParking(Parking parking) {
		this.parking = parking;
	}
	
	

}

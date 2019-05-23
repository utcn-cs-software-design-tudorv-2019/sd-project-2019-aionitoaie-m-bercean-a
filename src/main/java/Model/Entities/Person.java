package Model.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Person {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personID;
	private String address;
	private String name;
	private String phone;
	private String email;
	private String userP;
	private String passP;
	
	public Person() {}
	
	public Person(int id, String address, String name, String phone, String email, String user, String pass)
	{
		this.personID = id;
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.userP = user;
		this.passP = pass;
	}
	
	public Person(String address, String name, String phone, String email, String user, String pass)
	{
		this.address = address;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.userP = user;
		this.passP = pass;
	}
	
	public int getPersonID() {
		return personID;
	}



	public void setPersonID(int personID) {
		this.personID = personID;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUser() {
		return userP;
	}



	public void setUser(String user) {
		this.userP = user;
	}



	public String getPass() {
		return passP;
	}



	public void setPass(String pass) {
		this.passP = pass;
	}



	public String toString()
	{
		return "" + personID + " " + address + " " + name + " " + phone + " " + email + " " + userP + " " + passP;
	}
	
	
}

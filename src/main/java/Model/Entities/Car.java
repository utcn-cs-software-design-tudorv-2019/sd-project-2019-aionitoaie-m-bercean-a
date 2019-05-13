package Model.Entities;

import java.util.List;

import javax.persistence.*;


@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carID;
	private String model;
	private int year;
	
	@ManyToOne
	@JoinColumn(name = "personID")
	private Person person;

	public Car() {}
	
	public Car(String model, int year)
	{
		this.model = model;
		this.year = year;
	}
	
	public int getCarID() {
		return carID;
	}

	public void setCarID(int carID) {
		this.carID = carID;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	

}

package Model.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Plot implements Comparable<Plot> {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plotId;
	//private int Date;
	//private int startD;
	//private int duration;
	//private boolean occupied;
	private int price;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "parkId")
	private Parking parking;
	
	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}

	public Plot(/*int Date,*/ /*int start,*/ /*int duration,*/ /*boolean occupied,*/ int price)
	{
		//this.Date = Date;
		//this.startD = start;
		//this.duration = duration;
		//this.occupied = occupied;
		this.price = price;
	}
	
	public Plot() {}
	
	public int getPlotId() {
		return plotId;
	}
	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}
	/*public int getStartD() {
		return startD;
	}
	public void setStartD(int startD) {
		this.startD = startD;
	}*/
	/*public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}*/
	/*public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public boolean getOccupiedState()
	{
		return this.occupied;
	}*/
	/*public int getDate() {
		return Date;
	}
	public void setDate(int date) {
		Date = date;
	}*/
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int compareTo(Plot o)
	{
		return Integer.compare(this.getPlotId(), o.getPlotId());
	}

}

package Model.Entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Plot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plotId;
	private int Date;
	private int startD;
	private int endD;
	private boolean occupied;
	
	@ManyToOne
	@JoinColumn(name = "parkId")
	private Parking parking;
	
	public int getPlotId() {
		return plotId;
	}
	public void setPlotId(int plotId) {
		this.plotId = plotId;
	}
	public int getStartD() {
		return startD;
	}
	public void setStartD(int startD) {
		this.startD = startD;
	}
	public int getEndD() {
		return endD;
	}
	public void setEndD(int endD) {
		this.endD = endD;
	}
	public boolean isOccupied() {
		return occupied;
	}
	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
	
	public boolean getOccupiedState()
	{
		return this.occupied;
	}
	public int getDate() {
		return Date;
	}
	public void setDate(int date) {
		Date = date;
	}

}

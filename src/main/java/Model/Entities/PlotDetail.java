package Model.Entities;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class PlotDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int plotDetailId;
	
	private int startHour;
	private int endHour;
	private boolean occupied;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "plotId")
	private Plot plot;


	public int getPlotDetailId() {
		return plotDetailId;
	}


	public void setPlotDetailId(int plotDetailId) {
		this.plotDetailId = plotDetailId;
	}


	public int getStartHour() {
		return startHour;
	}


	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}


	public int getEndHour() {
		return endHour;
	}


	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}


	public boolean isOccupied() {
		return occupied;
	}


	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}


	public Plot getPlot() {
		return plot;
	}


	public void setPlot(Plot plot) {
		this.plot = plot;
	}
	
	

}
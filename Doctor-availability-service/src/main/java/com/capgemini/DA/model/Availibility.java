package com.capgemini.DA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name="Availibility")
public class Availibility {
	
	@Override
	public String toString() {
		return "Availibility [dId=" + dId + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dId;
	
	@Column(name= "FromTime")
	private String startTime;
	
	@Column(name="ToTime")
	private String endTime;

	public String getstartTime() {
		return startTime;
	}

	public void setstartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getendTime() {
		return endTime;
	}

	public void setendTime(String endTime) {
		this.endTime = endTime;
	}
	
	

}

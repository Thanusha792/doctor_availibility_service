package com.cap.DA.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.List;


import javax.persistence.*;

@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@Column(name = "doctorId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int doctorId;
	
	@Column(name= "Doctor_Name")
	private String doctorName;
	
	@OneToMany(
	        cascade = CascadeType.ALL
	    )
	private List<Availibility> availibility;
	
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Doctor(int doctorId, String doctorName) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
	}
	

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public List<Availibility> getAvailibity() {
		return availibility;
	}


	public void setAvailibity(List<Availibility> availibility) {
		this.availibility = availibility;
	}
	
	

	
}

package com.capgemini.DA.service;

import com.capgemini.DA.Dto.Doctors;
import com.capgemini.DA.exception.FieldEmptyException;
import com.capgemini.DA.exception.NoDoctorsFound;
import com.capgemini.DA.model.Doctor;

import java.util.List;

public interface DoctorService {
	
	public boolean addDoctor(Doctor doctor) throws FieldEmptyException;
	public List<Doctor> findAllDoctors() throws NoDoctorsFound;
	public List<Doctors>  findDoctorsByTime(String startTime, String endTime)  throws NoDoctorsFound;

}

package com.cap.DA.service;

import com.cap.DA.Dto.Doctors;
import com.cap.DA.exception.FieldEmptyException;
import com.cap.DA.exception.NoDoctorsFound;
import com.cap.DA.model.Doctor;

import java.util.List;

public interface DoctorService {
	
	public boolean addDoctor(Doctor doctor) throws FieldEmptyException;
	public List<Doctor> findAllDoctors() throws NoDoctorsFound;
	public List<Doctors>  findDoctorsByTime(String startTime, String endTime)  throws NoDoctorsFound;

}

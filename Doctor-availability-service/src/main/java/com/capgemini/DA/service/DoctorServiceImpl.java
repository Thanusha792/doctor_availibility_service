package com.capgemini.DA.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.DA.repository.AvailibilityRepository;
import com.capgemini.DA.repository.DoctorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.ArrayList;
import java.util.List;

import com.capgemini.DA.Dto.Doctors;
import com.capgemini.DA.controller.Doctor_Availibility_Service_Controller;
import com.capgemini.DA.exception.FieldEmptyException;
import com.capgemini.DA.exception.NoDoctorsFound;
import com.capgemini.DA.model.Availibility;
import com.capgemini.DA.model.Doctor;

@Service("doctorService")
public class DoctorServiceImpl implements DoctorService{
	
	
	Logger logger= LoggerFactory.getLogger(Doctor_Availibility_Service_Controller.class);
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AvailibilityRepository availibilityRepository;
	
	/*
	 * This method created a doctor row by taking doctor object as input
	 */
	@Override
	@Transactional
	public boolean addDoctor(Doctor doctor) throws FieldEmptyException {
		
		boolean result = false;
		if (doctor.getDoctorId()!=-1 && doctor.getDoctorName() != null) {
			String name = doctor.getDoctorName();
			String regex = "^[A-Za-z ]+";
			if (name.matches(regex)) {
				doctor = doctorRepository.save(doctor);
				result = true;
					return result;
			}
			logger.error("incorrect details");
			throw new FieldEmptyException("Not able to add admin record");
			
		}
		throw new FieldEmptyException("Some field is missing");
	
	}
	
	/*
	 * This method returns list of doctors which are stored in the database
	 */
	
	@Override
	public List<Doctor> findAllDoctors() throws NoDoctorsFound{
		List<Doctor> doctor = doctorRepository.findAll();
			
			if (!doctor.isEmpty()) {
				return doctor;
			}
			logger.error("No doctors");
			throw new NoDoctorsFound("No Doctors found");
			
	}
	
	 /*
     * This method returns list of doctors by taking endTime and startTie as input parameter
     * @Param endTime;
     * @Param startTime
     */
	
	@Override
	public List<Doctors>  findDoctorsByTime(String startTime,String endTime) {
		List<Doctors> doctors=new ArrayList<Doctors>();
		List<Doctor>  doctor=doctorRepository.readAllDoctorsByAvailibility(startTime, endTime);
		for(int i=0;i<doctor.size();i++) {
			Doctors doctorObject=new Doctors();
			doctorObject.setDoctorId(doctor.get(i).getDoctorId());
			doctorObject.setDoctorName(doctor.get(i).getDoctorName());
			doctors.add(doctorObject);
		}
				return doctors;
			
	}

}

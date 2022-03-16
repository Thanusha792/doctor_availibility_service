package com.cap.DA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cap.DA.Dto.Doctors;
import com.cap.DA.Dto.InputTime;
import com.cap.DA.exception.FieldEmptyException;
import com.cap.DA.exception.NoDoctorsFound;
import com.cap.DA.model.Doctor;
import com.cap.DA.service.DoctorServiceImpl;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "DA/availibility")
public class Doctor_Availibility_Service_Controller {
	
	@Autowired
	private DoctorServiceImpl doctorService;
	
	/*
	 * This method sends doctor object to service layer
	 */
	
	@PostMapping(path = "/addDoctor")
	public ResponseEntity<String> saveDoctor(@RequestBody Doctor doctor) throws FieldEmptyException {
		ResponseEntity<String> response = null;
		if (doctorService.addDoctor(doctor)) {
			response = new ResponseEntity<String>("Added successfully", HttpStatus.CREATED);
		}
		else
		{
				response= new ResponseEntity<String>("Failed to create your account please try again Reason:",HttpStatus.BAD_REQUEST);
			
		}
		return response;
	}	
	
	/*
	 * This method returns list of doctors which are stored in the database from service layer
	 */
	
	    @GetMapping(path = "/findAllDoctors")
	    public List<Doctor> findAllDoctor() throws NoDoctorsFound{
		 List<Doctor> doctor= doctorService.findAllDoctors();
		 return doctor;
	    }
	    
	    /*
	     * This method sends two parameters endTime and startTie as input parameter
	     * @Param endTime;
	     * @Param startTime
	     */
	    
	    @GetMapping(path = "/findDoctors/{startTime}/{endTime}")
	    public List<Doctors> findDoctorsByTime(@PathVariable("startTime") String startTime,@PathVariable("endTime") String endTime) {
			List<Doctors> result = doctorService.findDoctorsByTime(startTime, endTime);
			ResponseEntity<List<Doctors>> response = new ResponseEntity<>(result, HttpStatus.OK);
			return result;
		}
//	    

}

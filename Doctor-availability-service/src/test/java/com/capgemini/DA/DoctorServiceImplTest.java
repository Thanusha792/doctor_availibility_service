package com.cap.DA;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


import com.cap.DA.model.Availibility;
import com.cap.DA.model.Doctor;
import com.cap.DA.service.DoctorService;


import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DoctorServiceImplTest {
	
	@Autowired
	private DoctorService doctorService;

	
	@Test
	void testToAddDoctor() {
		
		Availibility a1=new Availibility();
		a1.setendTime("12-30-2022TO8:00");
		a1.setstartTime("12-30-2022TO8:00");
		Availibility a2=new Availibility();
		a2.setendTime("time1");
		a2.setstartTime("time2");
		List<Availibility>  availibitylist=new ArrayList<Availibility>();
		availibitylist.add(a1);
		availibitylist.add(a2);
		Doctor expected =new Doctor();
		expected.setDoctorName("John Smith");
		expected.setAvailibity(availibitylist);
		boolean result = doctorService.addDoctor(expected);
		assertTrue(result);
	}
	
	@Test
	void testtoGetAllDoctors() {
		
		Availibility a1=new Availibility();
		a1.setendTime("12-30-2022TO8:00");
		a1.setstartTime("12-30-2022TO8:00");
		Availibility a2=new Availibility();
		a2.setendTime("time1");
		a2.setstartTime("time2");
		List<Availibility>  availibitylist=new ArrayList();
		availibitylist.add(a1);
		availibitylist.add(a2);
		Doctor expected =new Doctor();
		expected.setDoctorName("John Smith");
		expected.setAvailibity(availibitylist);
		doctorService.addDoctor(expected);
		List<Doctor> doctor=doctorService.findAllDoctors();
		assertNotNull(doctor);
		
	}
	
		

}

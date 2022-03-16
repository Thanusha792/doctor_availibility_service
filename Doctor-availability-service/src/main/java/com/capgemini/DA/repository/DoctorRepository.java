package com.cap.DA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cap.DA.Dto.Doctors;
import com.cap.DA.model.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {


//	public List<Election> readAllElectionsByDate(@Param("from") String from, @Param("to") String to);
	
	@Query(value = "Select d from Doctor d JOIN d.availibility a where a.startTime=:starttime and a.endTime=:endtime")
	public List<Doctor> readAllDoctorsByAvailibility(@Param("starttime") String starttime,@Param("endtime") String endtime);
}

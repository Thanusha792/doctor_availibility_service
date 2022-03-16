package com.capgemini.DA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cap.DA.model.Availibility;

@Repository
public interface AvailibilityRepository extends JpaRepository<Availibility, Integer>{

}

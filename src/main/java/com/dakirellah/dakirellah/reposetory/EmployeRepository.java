package com.dakirellah.dakirellah.reposetory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dakirellah.dakirellah.entities.Employe;
import com.dakirellah.dakirellah.entities.Service;

 

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
//	List<Employe> findBySpecialite(Service service);
	
	 
}

package com.dakirellah.dakirellah.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


 
import com.dakirellah.dakirellah.entities.Service;

 

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}


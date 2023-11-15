package com.dakirellah.dakirellah.controller;

 

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dakirellah.dakirellah.entities.Employe;
import com.dakirellah.dakirellah.entities.Service;
import com.dakirellah.dakirellah.services.ServiceService;

 
@RestController
@RequestMapping("/api/v1/Services")
public class ServiceController {
	@Autowired
	private ServiceService service;
	
	
	  
	@GetMapping
	public List<Service> findAllServices() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id) {
		Service Service = service.findById(id);
		if (Service == null) {
			return new ResponseEntity<Object>("Service avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);

		} else {
			return ResponseEntity.ok(Service);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletService(@PathVariable Long id) {
		Service Service = service.findById(id);
		if (Service == null) {
			return new ResponseEntity<Object>("Service avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);
		} else {
			service.delete(Service);
			return ResponseEntity.ok("Service avec id " + id + " suprimee");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateService(@PathVariable Long id, @RequestBody Service newService) {

		Service oldService = service.findById(id);
		if (oldService == null) {
			return new ResponseEntity<Object>("Service avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

		} else {
			newService.setId(id);
			return ResponseEntity.ok(service.update(newService));
		}
	}

	@PostMapping
	public Service creatService(@RequestBody Service Service) {
		Service.setId(0L);
		return service.create(Service);

	}

}

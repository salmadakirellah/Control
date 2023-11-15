package com.dakirellah.dakirellah.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.dakirellah.dakirellah.services.EmployeService;

 
@RestController
@RequestMapping("/api/v1/Employes")
public class EmployeController {
    @Autowired
    private EmployeService service;

    @GetMapping
    public List<Employe> findAllEmployes() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Employe Employe = service.findById(id);
        if (Employe == null) {
            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);

        } else {
            return ResponseEntity.ok(Employe);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletEmploye(@PathVariable Long id) {
        Employe Employe = service.findById(id);
        if (Employe == null) {
            return new ResponseEntity<Object>("Employe avec Id " + id + " nexiste pas", HttpStatus.BAD_REQUEST);
        } else {
            service.delete(Employe);
            return ResponseEntity.ok("Employe avec id " + id + " suprime");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateEmploye(@PathVariable Long id, @RequestBody Employe newEmploye) {

        Employe oldEmploye = service.findById(id);
        if (oldEmploye == null) {
            return new ResponseEntity<Object>("Employe avec id" + id + "nexiste pas ", HttpStatus.BAD_REQUEST);

        } else {
            newEmploye.setId(id);
            return ResponseEntity.ok(service.update(newEmploye));
        }
    }

    @PostMapping
    public Employe creatEmploye(@RequestBody Employe Employe) {
        Employe.setId(0L);
        return service.create(Employe);
    }
    
     
}

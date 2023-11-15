package com.dakirellah.dakirellah.services;

 

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dakirellah.dakirellah.dao.IDao;
import com.dakirellah.dakirellah.entities.Employe;
import com.dakirellah.dakirellah.services.EmployeService;
import com.dakirellah.dakirellah.reposetory.*;

 

@Service
public class EmployeService implements IDao<Employe>{

    @Autowired
    EmployeRepository EmployeRepository;
    @Override
    public Employe create(Employe o) {
       return EmployeRepository.save(o);
    }

    @Override
    public List<Employe> findAll() {
        return EmployeRepository.findAll();
    }

    @Override
    public Employe update(Employe o) {
        return EmployeRepository.save(o);
    }

    @Override
    public boolean delete(Employe o) {
        try {
            EmployeRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Employe findById(Long id) {
        return EmployeRepository.findById(id).orElse(null);
    }
    
   
    
}

package com.dakirellah.dakirellah.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dakirellah.dakirellah.dao.IDao;
import com.dakirellah.dakirellah.entities.Employe;
import com.dakirellah.dakirellah.entities.Service;
import com.dakirellah.dakirellah.reposetory.*;

 

@org.springframework.stereotype.Service
public class ServiceService implements IDao<Service> {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Service create(Service s) {
        return serviceRepository.save(s);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Service update(Service o) {
        return serviceRepository.save(o);
    }

    @Override
    public boolean delete(Service o) {
        try {
            serviceRepository.delete(o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Service findById(Long id) {
        return serviceRepository.findById(id).orElse(null);
    }
    
    public void afficherCollaborateursSousResponsabilite(Employe chef) {
        // Afficher les informations sur le chef
        System.out.println("Collaborateurs sous la responsabilité de " + chef.getPrenom() + " " + chef.getNom() + ":");

        // Afficher les employés sous la responsabilité du chef
        List<Employe> subordonnes = chef.getSubordonnes();

        if (subordonnes != null && !subordonnes.isEmpty()) {
            for (Employe employe : subordonnes) {
                System.out.println(employe.getPrenom() + " " + employe.getNom());
            }
        } else {
            System.out.println("Aucun employé sous la responsabilité.");
        }
    }
}


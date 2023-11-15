package com.dakirellah.dakirellah.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Employe {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String photo;
	
	
	@ManyToOne
    private Service service;

    @ManyToOne
    private Employe chef;

    @OneToMany(mappedBy = "chef", cascade = CascadeType.ALL)
    private List<Employe> subordonnes = new ArrayList<>();
	
	
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

    public List<Employe> getSubordonnes() {
        return subordonnes;
    }

    public void setSubordonnes(List<Employe> subordonnes) {
        this.subordonnes = subordonnes;
    }
	
    public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Employe getChef() {
		return chef;
	}
	public void setChef(Employe chef) {
		this.chef = chef;
	}

	    
	
	

}

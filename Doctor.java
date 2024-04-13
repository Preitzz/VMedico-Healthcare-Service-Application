package com.vmedico.medapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private String drgender;
    private String drphone;
    private String dremail;

 

    public String getDrgender() {
		return drgender;
	}

	public void setDrgender(String drgender) {
		this.drgender = drgender;
	}

	public String getDrphone() {
		return drphone;
	}

	public void setDrphone(String drphone) {
		this.drphone = drphone;
	}

	public String getDremail() {
		return dremail;
	}

	public void setDremail(String dremail) {
		this.dremail = dremail;
	}

	public Doctor() {
    }

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}


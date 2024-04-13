package com.vmedico.medapp.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(length = 500)
    private String medication;

    private String dosage;

    @Temporal(TemporalType.TIMESTAMP)
    private Date datePrescribed;

    // Default constructor
    public Prescription() {
    }

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}


}

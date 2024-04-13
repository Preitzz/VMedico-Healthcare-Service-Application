package com.vmedico.medapp.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class LabResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column(length = 500)
    private String testName;

    @Column(length = 2000)
    private String result;

    @Temporal(TemporalType.DATE)
    private Date dateOfTest;

    // Default constructor
    public LabResult() {
    }

 
}

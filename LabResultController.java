package com.vmedico.medapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vmedico.medapp.model.LabResult;
import com.vmedico.medapp.service.LabResultService;

import java.util.List;

@RestController
@RequestMapping("/labresults")
public class LabResultController {

    private final LabResultService labResultService;

 
    public LabResultController(LabResultService labResultService) {
        this.labResultService = labResultService;
    }

    @GetMapping
    public ResponseEntity<List<LabResult>> getAllLabResults() {
        List<LabResult> labResults = labResultService.getAllLabResults();
        return new ResponseEntity<>(labResults, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LabResult> getLabResultById(@PathVariable Long id) {
        LabResult labResult = labResultService.getLabResultById(id);
        return new ResponseEntity<>(labResult, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LabResult> addLabResult(@RequestBody LabResult labResult) {
        LabResult newLabResult = labResultService.saveOrUpdateLabResult(labResult);
        return new ResponseEntity<>(newLabResult, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LabResult> updateLabResult(@PathVariable Long id, @RequestBody LabResult labResult) {
        LabResult updateLabResult = labResultService.saveOrUpdateLabResult(labResult);
        return new ResponseEntity<>(updateLabResult, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLabResult(@PathVariable Long id) {
    	
    
    labResultService.deleteLabResult(id);
    return new ResponseEntity<>(HttpStatus.OK);
   }
     }
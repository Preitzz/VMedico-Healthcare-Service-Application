package com.vmedico.medapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vmedico.medapp.model.LabResult;
import com.vmedico.medapp.repository.LabResultRepository;

import java.util.List;

@Service
public class LabResultService {

    @Autowired
    private LabResultRepository labResultRepository;

    public List<LabResult> getAllLabResults() {
        return labResultRepository.findAll();
    }

    public LabResult getLabResultById(Long id) {
        return labResultRepository.findById(id).orElse(null);
    }

    public LabResult saveOrUpdateLabResult(LabResult labResult) {
        return labResultRepository.save(labResult);
    }

    public void deleteLabResult(Long id) {
        labResultRepository.deleteById(id);
    }
}
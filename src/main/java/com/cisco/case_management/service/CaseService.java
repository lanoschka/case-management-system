package com.cisco.case_management.service;

import com.cisco.case_management.model.Case;
import com.cisco.case_management.repository.CaseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class CaseService {

    private final CaseRepository caseRepository;

    @Autowired
    public CaseService(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    public List<Case> getAllCases() {
        return caseRepository.findAll();
    }

    public Case createCase(Case newCase) {
        newCase.setCreationDate(LocalDateTime.now());
        return caseRepository.save(newCase);
    }

    public Case updateCase(Long id, Case updatedCase) {
        return caseRepository.findById(id)
                .map(caseFromDb -> {
                    caseFromDb.setTitle(updatedCase.getTitle());
                    caseFromDb.setDescription(updatedCase.getDescription());
                    caseFromDb.setSeverity(updatedCase.getSeverity());
                    caseFromDb.setStatus(updatedCase.getStatus());
                    return caseRepository.save(caseFromDb);
                })
                .orElseThrow(() -> new IllegalArgumentException("Case not found with id: " + id));
    }

    public void deleteCase(Long id) {
        caseRepository.deleteById(id);
    }
}

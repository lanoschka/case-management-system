package com.cisco.case_management.repository;

import com.cisco.case_management.model.Case;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaseRepository extends JpaRepository<Case, Long> {
}

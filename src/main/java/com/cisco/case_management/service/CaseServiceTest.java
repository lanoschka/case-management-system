package com.cisco.case_management.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.cisco.case_management.model.Case;
import com.cisco.case_management.repository.CaseRepository;
import com.cisco.case_management.service.CaseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class CaseServiceTest {

    @Mock
    private CaseRepository caseRepository;

    @InjectMocks
    private CaseService caseService;

    private Case mockCase;

    @BeforeEach
    void setUp() {
        // Tworzymy przykładowy obiekt Case
        mockCase = new Case(1L, "Test case", "Description", null, null, null);
    }

    @Test
    void testGetCaseById() {
        // Konfiguracja mocka: gdy findById(1L) zostanie wywołane, zwróć mockCase
        when(caseRepository.findById(1L)).thenReturn(Optional.of(mockCase));

        // Wywołujemy metodę getCaseById
        Optional<Case> foundCase = caseService.getCaseById(1L);

        // Sprawdzamy, czy obiekt został znaleziony
        assertTrue(foundCase.isPresent());
        assertEquals("Test case", foundCase.get().getTitle());
    }

    @Test
    void testCreateCase() {
        // Konfiguracja mocka: gdy zapisujemy case, zwracamy ten sam obiekt
        when(caseRepository.save(any(Case.class))).thenReturn(mockCase);

        // Wywołujemy metodę createCase
        Case createdCase = caseService.createCase(mockCase);

        // Sprawdzamy, czy obiekt został poprawnie zapisany
        assertNotNull(createdCase);
        assertEquals(mockCase.getId(), createdCase.getId());
    }
}
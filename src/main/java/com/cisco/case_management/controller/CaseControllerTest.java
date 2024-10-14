package com.cisco.case_management.controller;


import com.cisco.case_management.model.Case;
import com.cisco.case_management.repository.CaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CaseRepository caseRepository;

    @Test
    void testGetCaseById() throws Exception {
        // Tworzymy przykładowy case w repozytorium
        Case testCase = new Case(null, "Test case", "Description", null, null, null);
        caseRepository.save(testCase);

        // Wywołujemy GET /api/cases/{id} i sprawdzamy odpowiedź
        mockMvc.perform(get("/api/cases/" + testCase.getId())
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Test case"));
    }
}
package com.cisco.case_management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Getter
@Entity
public class Case {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime creationDate;


    public enum Severity {
        LOW, MEDIUM, HIGH
    }

    private Severity severity;

    public enum Status {
        NEW, IN_PROGRESS, DONE
    }

    private Status status;

    public Case() {
    }

    public Case(Long id, String title, String description, LocalDateTime creationDate, Severity severity, Status status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.severity = severity;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

package com.backendchallenge.traceabilityservice.domain.model;


import java.time.LocalDateTime;

public class StatusChange {
    private LocalDateTime date;
    private String status;

    public StatusChange() {
    }

    public StatusChange(LocalDateTime date, String status) {
        this.date = date;
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

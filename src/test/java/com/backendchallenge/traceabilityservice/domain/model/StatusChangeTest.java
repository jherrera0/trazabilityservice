package com.backendchallenge.traceabilityservice.domain.model;

import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StatusChangeTest {

    @Test
    void constructor_initializesFieldsCorrectly() {
        LocalDateTime date = LocalDateTime.now();
        String status = ConstTest.STATUS_TEST;
        StatusChange statusChange = new StatusChange(date, status);

        assertEquals(date, statusChange.getDate());
        assertEquals(status, statusChange.getStatus());
    }

    @Test
    void setDate_updatesDateField() {
        StatusChange statusChange = new StatusChange();
        LocalDateTime date = LocalDateTime.now();
        statusChange.setDate(date);

        assertEquals(date, statusChange.getDate());
    }

    @Test
    void setStatus_updatesStatusField() {
        StatusChange statusChange = new StatusChange();
        String status = ConstTest.STATUS_TEST;
        statusChange.setStatus(status);

        assertEquals(status, statusChange.getStatus());
    }
}
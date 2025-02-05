package com.backendchallenge.traceabilityservice.domain.model;

import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeEfficiencyTest {
    @Test
    void employeeEfficiency_withValidData_setsFieldsCorrectly() {
        Long employeeId = ConstTest.ID_TEST;
        double averageTime = 15.5;

        EmployeeEfficiency employeeEfficiency = new EmployeeEfficiency(employeeId, averageTime);

        assertEquals(employeeId, employeeEfficiency.getEmployeeId());
        assertEquals(averageTime, employeeEfficiency.getAverageTime(), 0.01);
    }

    @Test
    void employeeEfficiency_defaultConstructor_initializesFieldsToNull() {
        EmployeeEfficiency employeeEfficiency = new EmployeeEfficiency();

        assertNull(employeeEfficiency.getEmployeeId());
        assertEquals(0.0, employeeEfficiency.getAverageTime(), 0.01);
    }

    @Test
    void setEmployeeId_withValidId_setsEmployeeId() {
        EmployeeEfficiency employeeEfficiency = new EmployeeEfficiency();
        Long employeeId = ConstTest.ID_TEST;

        employeeEfficiency.setEmployeeId(employeeId);

        assertEquals(employeeId, employeeEfficiency.getEmployeeId());
    }

    @Test
    void setAverageTime_withValidTime_setsAverageTime() {
        EmployeeEfficiency employeeEfficiency = new EmployeeEfficiency();
        double averageTime = 15.5;

        employeeEfficiency.setAverageTime(averageTime);

        assertEquals(averageTime, employeeEfficiency.getAverageTime(), 0.01);
    }

}
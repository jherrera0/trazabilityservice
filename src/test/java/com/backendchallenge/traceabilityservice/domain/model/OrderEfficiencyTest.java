package com.backendchallenge.traceabilityservice.domain.model;

import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderEfficiencyTest {
    @Test
    void orderEfficiency_withValidData_setsFieldsCorrectly() {
        Long orderId = ConstTest.ID_TEST;
        Long employeeId = ConstTest.ID_TEST;
        long processingTimeMinutes = ConstTest.ID_TEST;

        OrderEfficiency orderEfficiency = new OrderEfficiency(orderId, employeeId, processingTimeMinutes);

        assertEquals(orderId, orderEfficiency.getOrderId());
        assertEquals(employeeId, orderEfficiency.getEmployeeId());
        assertEquals(processingTimeMinutes, orderEfficiency.getProcessingTimeMinutes());
    }

    @Test
    void orderEfficiency_defaultConstructor_initializesFieldsToNull() {
        OrderEfficiency orderEfficiency = new OrderEfficiency();

        assertNull(orderEfficiency.getOrderId());
        assertNull(orderEfficiency.getEmployeeId());
        assertEquals(ConstValidation.ZERO.longValue(), orderEfficiency.getProcessingTimeMinutes());
    }

    @Test
    void setOrderId_withValidId_setsOrderId() {
        OrderEfficiency orderEfficiency = new OrderEfficiency();
        Long orderId = ConstTest.ID_TEST;

        orderEfficiency.setOrderId(orderId);

        assertEquals(orderId, orderEfficiency.getOrderId());
    }

    @Test
    void setEmployeeId_withValidId_setsEmployeeId() {
        OrderEfficiency orderEfficiency = new OrderEfficiency();
        Long employeeId = ConstTest.ID_TEST;

        orderEfficiency.setEmployeeId(employeeId);

        assertEquals(employeeId, orderEfficiency.getEmployeeId());
    }

    @Test
    void setProcessingTimeMinutes_withValidTime_setsProcessingTimeMinutes() {
        OrderEfficiency orderEfficiency = new OrderEfficiency();
        long processingTimeMinutes = ConstTest.ID_TEST;

        orderEfficiency.setProcessingTimeMinutes(processingTimeMinutes);

        assertEquals(processingTimeMinutes, orderEfficiency.getProcessingTimeMinutes());
    }

}
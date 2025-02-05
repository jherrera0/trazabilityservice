package com.backendchallenge.traceabilityservice.infrastructure.controller;

import com.backendchallenge.traceabilityservice.application.http.dto.request.AssignEmployeeToOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.UpdateOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderTraceabilityResponse;
import com.backendchallenge.traceabilityservice.application.http.handler.interfaces.IOrderTraceabilityHandler;
import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class TraceabilityRestControllerTest {

    @Mock
    private IOrderTraceabilityHandler orderTraceabilityHandler;

    @InjectMocks
    private TraceabilityRestController traceabilityRestController;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
      closeable =  MockitoAnnotations.openMocks(this);
    }

    @Test
    @WithMockUser(authorities = "CLIENT")
    void createOrderTraceability_validRequest_returnsCreated() {
        OrderTraceabilityRequest request = new OrderTraceabilityRequest();
        doNothing().when(orderTraceabilityHandler).createOrderTraceability(request);

        ResponseEntity<Void> response = traceabilityRestController.createOrderTraceability(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }



    @Test
    @WithMockUser(authorities = "EMPLOYEE")
    void assignEmployeeToOrderTraceability_validRequest_returnsCreated() {
        AssignEmployeeToOrderTraceabilityRequest request = new AssignEmployeeToOrderTraceabilityRequest();
        doNothing().when(orderTraceabilityHandler).assignEmployeeToOrderTraceability(request);

        ResponseEntity<Void> response = traceabilityRestController.assignEmployeeToOrderTraceability(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }


    @Test
    @WithMockUser(authorities = "CLIENT")
    void getOrderTraceabilityById_validId_returnsOk() {
        Long id = ConstTest.ID_TEST;
        OrderTraceabilityResponse responseMock = new OrderTraceabilityResponse();
        when(orderTraceabilityHandler.getOrderTraceabilityById(id)).thenReturn(responseMock);

        ResponseEntity<OrderTraceabilityResponse> response = traceabilityRestController.getOrderTraceabilityById(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseMock, response.getBody());
    }


    @Test
    @WithMockUser(authorities = "CLIENT")
    void updateOrderTraceability_validRequest_returnsCreated() {
        UpdateOrderTraceabilityRequest request = new UpdateOrderTraceabilityRequest();
        doNothing().when(orderTraceabilityHandler).updateOrderTraceability(request);

        ResponseEntity<Void> response = traceabilityRestController.updateOrderTraceability(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
}
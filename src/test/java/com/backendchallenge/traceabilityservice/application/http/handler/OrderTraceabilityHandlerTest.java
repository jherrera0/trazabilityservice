package com.backendchallenge.traceabilityservice.application.http.handler;

import com.backendchallenge.traceabilityservice.application.http.dto.request.AssignEmployeeToOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.UpdateOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderTraceabilityResponse;
import com.backendchallenge.traceabilityservice.domain.api.IOrderTraceabilityServicePort;
import com.backendchallenge.traceabilityservice.application.http.mapper.IOrderTraceabilityMapper;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderTraceabilityHandlerTest {

    @Mock
    private IOrderTraceabilityServicePort orderTraceabilityServicePort;

    @Mock
    private IOrderTraceabilityMapper orderTraceabilityMapper;

    @InjectMocks
    private OrderTraceabilityHandler orderTraceabilityHandler;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
      closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrderTraceability_validRequest_callsServicePort() {
        OrderTraceabilityRequest request = new OrderTraceabilityRequest();
        when(orderTraceabilityMapper.toDomain(request)).thenReturn(new Order());

        orderTraceabilityHandler.createOrderTraceability(request);

        verify(orderTraceabilityServicePort, times(ConstValidation.ONE)).createOrderTraceability(any(Order.class));
    }

    @Test
    void updateOrderTraceability_validRequest_callsServicePort() {
        UpdateOrderTraceabilityRequest request = new UpdateOrderTraceabilityRequest();
        request.setIdOrder(ConstTest.ID_TEST);
        request.setStatus(ConstTest.STATUS_TEST);
        request.setDate(LocalDateTime.now());

        orderTraceabilityHandler.updateOrderTraceability(request);

        verify(orderTraceabilityServicePort, times(ConstValidation.ONE)).updateOrderTraceability(ConstTest.ID_TEST,
                ConstTest.STATUS_TEST, request.getDate());
    }

    @Test
    void assignEmployeeToOrderTraceability_validRequest_callsServicePort() {
        AssignEmployeeToOrderTraceabilityRequest request = new AssignEmployeeToOrderTraceabilityRequest();
        request.setOrderId(ConstTest.ID_TEST);
        request.setEmployeeId(ConstTest.ID_TEST);

        orderTraceabilityHandler.assignEmployeeToOrderTraceability(request);

        verify(orderTraceabilityServicePort, times(ConstValidation.ONE))
                .assignEmployeeToOrder(ConstTest.ID_TEST, ConstTest.ID_TEST);
    }

    @Test
    void getOrderTraceabilityById_validId_returnsResponse() {
        Long id = ConstTest.ID_TEST;
        OrderTraceabilityResponse response = new OrderTraceabilityResponse();
        when(orderTraceabilityServicePort.getOrderTraceability(id)).thenReturn(new Order());
        when(orderTraceabilityMapper.toResponse(any(Order.class))).thenReturn(response);

        OrderTraceabilityResponse result = orderTraceabilityHandler.getOrderTraceabilityById(id);

        assertEquals(response, result);
    }
}
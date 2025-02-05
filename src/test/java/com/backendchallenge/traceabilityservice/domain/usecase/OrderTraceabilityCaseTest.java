package com.backendchallenge.traceabilityservice.domain.usecase;

import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.model.StatusChange;
import com.backendchallenge.traceabilityservice.domain.spi.IOrderTraceabilityPersistencePort;
import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderTraceabilityCaseTest {

    @Mock
    private IOrderTraceabilityPersistencePort orderTraceabilityPort;

    @InjectMocks
    private OrderTraceabilityCase orderTraceabilityCase;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
       closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrderTraceability_validOrder_callsPersistencePort() {
        Order order = new Order();

        orderTraceabilityCase.createOrderTraceability(order);

        verify(orderTraceabilityPort, times(ConstValidation.ONE)).createOrderTraceability(order);
    }

    @Test
    void assignEmployeeToOrder_validIds_callsPersistencePort() {
        Long idOrder = ConstTest.ID_TEST;
        Long idEmployee = ConstTest.ID_TEST;
        Order order = new Order();
        when(orderTraceabilityPort.getOrderByOrderId(idOrder)).thenReturn(order);

        orderTraceabilityCase.assignEmployeeToOrder(idOrder, idEmployee);

        assertEquals(idEmployee, order.getIdEmployee());
        verify(orderTraceabilityPort, times(ConstValidation.ONE)).createOrderTraceability(order);
    }

    @Test
    void updateOrderTraceability_validInputs_callsPersistencePort() {
        Long idOrder = ConstTest.ID_TEST;
        String status = ConstTest.STATUS_TEST;
        LocalDateTime date = LocalDateTime.now();
        Order order = new Order();
        List<StatusChange> statusChanges = new ArrayList<>();
        order.setStatusChanges(statusChanges);
        when(orderTraceabilityPort.getOrderByOrderId(idOrder)).thenReturn(order);

        orderTraceabilityCase.updateOrderTraceability(idOrder, status, date);

        assertEquals(ConstValidation.ONE, order.getStatusChanges().size());
        assertEquals(status, order.getStatusChanges().get(ConstValidation.ZERO).getStatus());
        assertEquals(date, order.getStatusChanges().get(ConstValidation.ZERO).getDate());
        verify(orderTraceabilityPort, times(ConstValidation.ONE)).createOrderTraceability(order);
    }

    @Test
    void getOrderTraceability_validId_returnsOrder() {
        Long idOrder = ConstTest.ID_TEST;
        Order order = new Order();
        when(orderTraceabilityPort.getOrderByOrderId(idOrder)).thenReturn(order);

        Order result = orderTraceabilityCase.getOrderTraceability(idOrder);

        assertEquals(order, result);
    }
}
package com.backendchallenge.traceabilityservice.domain.usecase;

import com.backendchallenge.traceabilityservice.domain.model.EmployeeEfficiency;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.model.OrderEfficiency;
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
    @Test
    void getOrdersEfficiency_noOrders_returnsEmptyList() {
        when(orderTraceabilityPort.getAllOrders()).thenReturn(new ArrayList<>());

        List<OrderEfficiency> result = orderTraceabilityCase.getOrdersEfficiency();

        assertEquals(ConstValidation.ZERO, result.size());
    }

    @Test
    void getEmployeesEfficiency_noOrders_returnsEmptyList() {
        when(orderTraceabilityPort.getAllOrders()).thenReturn(new ArrayList<>());

        List<EmployeeEfficiency> result = orderTraceabilityCase.getEmployeesEfficiency();

        assertEquals(ConstValidation.ZERO, result.size());
    }

    @Test
    void getOrdersEfficiency_validOrders_returnsOrderEfficiencyList() {
        List<Order> orders = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        List<StatusChange> statusChanges = new ArrayList<>();
        statusChanges
                .add(new StatusChange(now.minusMinutes(ConstTest.TEN),
                        ConstTest.STATUS_TEST+ConstTest.START));
        statusChanges.add(new StatusChange(now.minusMinutes(ConstTest.FIVE), ConstTest.STATUS_TEST));
        statusChanges.add(new StatusChange(now, ConstTest.STATUS_TEST+ConstTest.END));
        order.setStatusChanges(statusChanges);
        order.setStatusChanges(statusChanges);
        orders.add(order);
        when(orderTraceabilityPort.getAllOrders()).thenReturn(orders);

        List<OrderEfficiency> result = orderTraceabilityCase.getOrdersEfficiency();

        assertEquals(ConstValidation.ONE, result.size());
        assertEquals(ConstTest.TEN, result.get(ConstValidation.ZERO).getProcessingTimeMinutes());
    }

    @Test
    void getEmployeesEfficiency_validOrders_returnsEmployeeEfficiencyList() {
        List<Order> orders = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        order.setIdEmployee(ConstTest.ID_TEST);
        List<StatusChange> statusChanges = new ArrayList<>();
        statusChanges
                .add(new StatusChange(now.minusMinutes(ConstTest.TEN),
                        ConstTest.STATUS_TEST+ConstTest.START));
        statusChanges.add(new StatusChange(now.minusMinutes(ConstTest.FIVE), ConstTest.STATUS_TEST));
        statusChanges.add(new StatusChange(now, ConstTest.STATUS_TEST+ConstTest.END));
        order.setStatusChanges(statusChanges);
        orders.add(order);
        when(orderTraceabilityPort.getAllOrders()).thenReturn(orders);

        List<EmployeeEfficiency> result = orderTraceabilityCase.getEmployeesEfficiency();

        assertEquals(ConstValidation.ONE, result.size());
        assertEquals(ConstTest.ID_TEST, result.get(ConstValidation.ZERO).getEmployeeId());
        assertEquals(ConstTest.TEN, result.get(ConstValidation.ZERO).getAverageTime());
    }

    @Test
    void getOrdersEfficiency_validOrders_returnsEmpty() {
        List<Order> orders = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        Order order = new Order();
        List<StatusChange> statusChanges = new ArrayList<>();
        statusChanges
                .add(new StatusChange(now.minusMinutes(ConstTest.TEN),
                        ConstTest.STATUS_TEST+ConstTest.START));
        statusChanges.add(new StatusChange(now, ConstTest.STATUS_TEST+ConstTest.END));
        order.setStatusChanges(statusChanges);
        order.setStatusChanges(statusChanges);
        orders.add(order);
        when(orderTraceabilityPort.getAllOrders()).thenReturn(orders);

        List<OrderEfficiency> result = orderTraceabilityCase.getOrdersEfficiency();

        assertEquals(ConstValidation.ONE, result.size());
        assertEquals(ConstTest.TEN, result.get(ConstValidation.ZERO).getProcessingTimeMinutes());
    }
    @Test
    void getOrdersEfficiency_statusChangesNullOrLessThanTwo_returnsEmptyList() {
        List<Order> orders = new ArrayList<>();
        Order orderWithNullStatusChanges = new Order();
        orderWithNullStatusChanges.setStatusChanges(null);
        Order orderWithOneStatusChange = new Order();
        List<StatusChange> oneStatusChange = new ArrayList<>();
        oneStatusChange.add(new StatusChange(LocalDateTime.now(), ConstTest.STATUS_TEST));
        orderWithOneStatusChange.setStatusChanges(oneStatusChange);
        orders.add(orderWithNullStatusChanges);
        orders.add(orderWithOneStatusChange);
        when(orderTraceabilityPort.getAllOrders()).thenReturn(orders);

        List<OrderEfficiency> result = orderTraceabilityCase.getOrdersEfficiency();

        assertEquals(ConstValidation.ZERO, result.size());
    }
}
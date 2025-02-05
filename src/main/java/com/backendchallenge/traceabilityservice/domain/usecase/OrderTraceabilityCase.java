package com.backendchallenge.traceabilityservice.domain.usecase;

import com.backendchallenge.traceabilityservice.domain.api.IOrderTraceabilityServicePort;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.model.StatusChange;
import com.backendchallenge.traceabilityservice.domain.spi.IOrderTraceabilityPersistencePort;

import java.time.LocalDateTime;
import java.util.List;

public class OrderTraceabilityCase implements IOrderTraceabilityServicePort {
    private final IOrderTraceabilityPersistencePort orderTraceabilityPort;

    public OrderTraceabilityCase(IOrderTraceabilityPersistencePort orderTraceabilityPersistencePort) {
        this.orderTraceabilityPort = orderTraceabilityPersistencePort;
    }

    @Override
    public void createOrderTraceability(Order order) {
        orderTraceabilityPort.createOrderTraceability(order);
    }

    @Override
    public void assignEmployeeToOrder(Long idOrder, Long idEmployee) {
        Order order = orderTraceabilityPort.getOrderByOrderId(idOrder);
        order.setIdEmployee(idEmployee);
        orderTraceabilityPort.updateOrderTraceability(order);
    }

    @Override
    public void updateOrderTraceability(Long idOrder, String status, LocalDateTime date) {
        Order order = orderTraceabilityPort.getOrderByOrderId(idOrder);
        List<StatusChange> statusChanges = order.getStatusChanges();
        statusChanges.add(new StatusChange(date, status));
        order.setStatusChanges(statusChanges);
        orderTraceabilityPort.updateOrderTraceability(order);
    }

    @Override
    public Order getOrderTraceability(Long idOrder) {
        return orderTraceabilityPort.getOrderByOrderId(idOrder);
    }
}

package com.backendchallenge.traceabilityservice.domain.api;

import com.backendchallenge.traceabilityservice.domain.model.Order;

import java.time.LocalDateTime;

public interface IOrderTraceabilityServicePort {
    void createOrderTraceability(Order order);
    void assignEmployeeToOrder(Long idOrder, Long idEmployee);
    void updateOrderTraceability(Long idOrder, String status, LocalDateTime date);
    Order getOrderTraceability(Long idOrder);
}

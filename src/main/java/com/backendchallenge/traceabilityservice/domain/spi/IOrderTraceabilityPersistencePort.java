package com.backendchallenge.traceabilityservice.domain.spi;

import com.backendchallenge.traceabilityservice.domain.model.Order;

import java.util.List;

public interface IOrderTraceabilityPersistencePort {
    void createOrderTraceability(Order order);
    Order getOrderByOrderId(Long idOrder);

    List<Order> getAllOrders();
}

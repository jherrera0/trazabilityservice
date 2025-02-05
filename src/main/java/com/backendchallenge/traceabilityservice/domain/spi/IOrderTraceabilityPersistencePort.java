package com.backendchallenge.traceabilityservice.domain.spi;

import com.backendchallenge.traceabilityservice.domain.model.Order;

public interface IOrderTraceabilityPersistencePort {
    void createOrderTraceability(Order order);
    Order getOrderByOrderId(Long idOrder);
}

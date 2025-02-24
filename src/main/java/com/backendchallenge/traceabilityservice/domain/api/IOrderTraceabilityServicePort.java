package com.backendchallenge.traceabilityservice.domain.api;

import com.backendchallenge.traceabilityservice.domain.model.EmployeeEfficiency;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.model.OrderEfficiency;

import java.time.LocalDateTime;
import java.util.List;

public interface IOrderTraceabilityServicePort {
    void createOrderTraceability(Order order);
    void assignEmployeeToOrder(Long idOrder, Long idEmployee);
    void updateOrderTraceability(Long idOrder, String status, LocalDateTime date);
    Order getOrderTraceability(Long idOrder);
    List<OrderEfficiency> getOrdersEfficiency();
    List<EmployeeEfficiency> getEmployeesEfficiency();

}

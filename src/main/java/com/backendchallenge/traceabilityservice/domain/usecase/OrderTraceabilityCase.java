package com.backendchallenge.traceabilityservice.domain.usecase;

import com.backendchallenge.traceabilityservice.domain.api.IOrderTraceabilityServicePort;
import com.backendchallenge.traceabilityservice.domain.model.EmployeeEfficiency;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.model.OrderEfficiency;
import com.backendchallenge.traceabilityservice.domain.model.StatusChange;
import com.backendchallenge.traceabilityservice.domain.spi.IOrderTraceabilityPersistencePort;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        orderTraceabilityPort.createOrderTraceability(order);
    }

    @Override
    public void updateOrderTraceability(Long idOrder, String status, LocalDateTime date) {
        Order order = orderTraceabilityPort.getOrderByOrderId(idOrder);
        List<StatusChange> statusChanges = order.getStatusChanges();
        statusChanges.add(new StatusChange(date, status));
        order.setStatusChanges(statusChanges);
        orderTraceabilityPort.createOrderTraceability(order);
    }

    @Override
    public Order getOrderTraceability(Long idOrder) {
        return orderTraceabilityPort.getOrderByOrderId(idOrder);
    }

    @Override
    public List<OrderEfficiency> getOrdersEfficiency() {
        List<Order> orders = orderTraceabilityPort.getAllOrders();
        return orders.stream()
                .map(order -> {
                    List<StatusChange> statusChanges = order.getStatusChanges();
                    if (statusChanges == null || statusChanges.size() < ConstValidation.TWO) {
                        return null;
                    }
                    LocalDateTime start = statusChanges.get(ConstValidation.ZERO).getDate();
                    LocalDateTime end = statusChanges.get(statusChanges.size() - ConstValidation.ONE).getDate();
                    long processingTime = Duration.between(start, end).toMinutes();
                    return new OrderEfficiency(order.getId(), order.getIdEmployee(), processingTime);
                })
                .filter(Objects::nonNull)
                .toList();
    }

    @Override
    public List<EmployeeEfficiency> getEmployeesEfficiency() {
        List<OrderEfficiency> ordersEfficiency = getOrdersEfficiency();

        Map<Long, Double> employeeEfficiency = ordersEfficiency.stream()
                .collect(Collectors.groupingBy(
                        OrderEfficiency::getEmployeeId,
                        Collectors.averagingLong(OrderEfficiency::getProcessingTimeMinutes)
                ));

        return employeeEfficiency.entrySet().stream()
                .map(entry -> new EmployeeEfficiency(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparingDouble(EmployeeEfficiency::getAverageTime))
                .toList();
    }

}

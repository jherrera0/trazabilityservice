package com.backendchallenge.traceabilityservice.application.http.handler;

import com.backendchallenge.traceabilityservice.application.http.dto.request.AssignEmployeeToOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.UpdateOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderTraceabilityResponse;
import com.backendchallenge.traceabilityservice.application.http.handler.interfaces.IOrderTraceabilityHandler;
import com.backendchallenge.traceabilityservice.application.http.mapper.IOrderTraceabilityMapper;
import com.backendchallenge.traceabilityservice.domain.api.IOrderTraceabilityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderTraceabilityHandler implements IOrderTraceabilityHandler {
    private final IOrderTraceabilityServicePort orderTraceabilityServicePort;
    private final IOrderTraceabilityMapper orderTraceabilityMapper;
    @Override
    public void createOrderTraceability(OrderTraceabilityRequest request) {
        orderTraceabilityServicePort.createOrderTraceability(orderTraceabilityMapper.toDomain(request));
    }

    @Override
    public void updateOrderTraceability(UpdateOrderTraceabilityRequest request) {
        orderTraceabilityServicePort.updateOrderTraceability(request.getIdOrder(),request.getStatus(),request.getDate());
    }

    @Override
    public void assignEmployeeToOrderTraceability(AssignEmployeeToOrderTraceabilityRequest request) {
        orderTraceabilityServicePort.assignEmployeeToOrder(request.getOrderId(),request.getEmployeeId());
    }

    @Override
    public OrderTraceabilityResponse getOrderTraceabilityById(Long id) {
        return orderTraceabilityMapper.toResponse(orderTraceabilityServicePort.getOrderTraceability(id));
    }
}

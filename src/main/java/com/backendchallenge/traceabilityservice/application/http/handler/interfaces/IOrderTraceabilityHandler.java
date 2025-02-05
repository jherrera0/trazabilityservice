package com.backendchallenge.traceabilityservice.application.http.handler.interfaces;

import com.backendchallenge.traceabilityservice.application.http.dto.request.AssignEmployeeToOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.UpdateOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderTraceabilityResponse;

public interface IOrderTraceabilityHandler {
    void createOrderTraceability(OrderTraceabilityRequest request);
    void updateOrderTraceability(UpdateOrderTraceabilityRequest request);
    void assignEmployeeToOrderTraceability(AssignEmployeeToOrderTraceabilityRequest request);
    OrderTraceabilityResponse getOrderTraceabilityById(Long id);
}

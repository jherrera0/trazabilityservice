package com.backendchallenge.traceabilityservice.application.http.mapper;

import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderTraceabilityResponse;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderTraceabilityMapper {
    Order toDomain(OrderTraceabilityRequest request);
    OrderTraceabilityResponse toResponse(Order order);
}

package com.backendchallenge.traceabilityservice.application.http.mapper;

import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderTraceabilityResponse;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderTraceabilityMapper {
    Order toDomain(OrderTraceabilityRequest request);
    @Mapping(target = "id", source = "id")
    @Mapping(target = "idClient", source = "idClient")
    @Mapping(target = "idEmployee", source = "idEmployee")
    @Mapping(target = "idRestaurant", source = "idRestaurant")
    @Mapping(target = "dishes", source = "dishes")
    @Mapping(target = "statusChanges", source = "statusChanges")
    OrderTraceabilityResponse toResponse(Order order);
}

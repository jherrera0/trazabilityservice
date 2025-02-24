package com.backendchallenge.traceabilityservice.application.http.mapper;

import com.backendchallenge.traceabilityservice.application.http.dto.response.OrderEfficiencyResponse;
import com.backendchallenge.traceabilityservice.domain.model.OrderEfficiency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEfficiencyResponseMapper {
    @Mapping(target = "orderId",source = "orderId")
    OrderEfficiencyResponse toResponse(OrderEfficiency orderEfficiency);
    List<OrderEfficiencyResponse> toResponseList(List<OrderEfficiency> orderEfficiencies);
}

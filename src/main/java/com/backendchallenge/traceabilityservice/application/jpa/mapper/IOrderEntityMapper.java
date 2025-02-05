package com.backendchallenge.traceabilityservice.application.jpa.mapper;

import com.backendchallenge.traceabilityservice.application.jpa.entity.OrderEntity;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IOrderEntityMapper {
    @Mapping(target = "id", ignore = true)
    OrderEntity toEntity(Order order);
    Order toDomain(OrderEntity orderEntity);
}

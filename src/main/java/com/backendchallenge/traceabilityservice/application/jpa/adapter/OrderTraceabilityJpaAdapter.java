package com.backendchallenge.traceabilityservice.application.jpa.adapter;

import com.backendchallenge.traceabilityservice.application.jpa.entity.OrderEntity;
import com.backendchallenge.traceabilityservice.application.jpa.mapper.IOrderEntityMapper;
import com.backendchallenge.traceabilityservice.application.jpa.repository.IOrderTraceabilityRepository;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.spi.IOrderTraceabilityPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderTraceabilityJpaAdapter implements IOrderTraceabilityPersistencePort {
    private final IOrderEntityMapper orderEntityMapper;
    private final IOrderTraceabilityRepository orderTraceabilityRepository;


    @Override
    public void createOrderTraceability(Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        orderTraceabilityRepository.save(orderEntity);
    }

    @Override
    public void updateOrderTraceability(Order order) {
        OrderEntity orderEntity = orderEntityMapper.toEntity(order);
        orderTraceabilityRepository.save(orderEntity);
    }

    @Override
    public Order getOrderByOrderId(Long idOrder) {
        return orderTraceabilityRepository.findById(idOrder)
                .map(orderEntityMapper::toDomain)
                .orElse(null);
    }
}

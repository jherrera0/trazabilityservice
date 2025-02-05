package com.backendchallenge.traceabilityservice.application.jpa.repository;

import com.backendchallenge.traceabilityservice.application.jpa.entity.OrderEntity;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IOrderTraceabilityRepository extends MongoRepository<OrderEntity,Long> {

    Order findById(String id);
}

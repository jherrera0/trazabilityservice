package com.backendchallenge.traceabilityservice.infrastructure.configuration;

import com.backendchallenge.traceabilityservice.application.jpa.adapter.OrderTraceabilityJpaAdapter;
import com.backendchallenge.traceabilityservice.application.jpa.mapper.IOrderEntityMapper;
import com.backendchallenge.traceabilityservice.application.jpa.repository.IOrderTraceabilityRepository;
import com.backendchallenge.traceabilityservice.domain.api.IOrderTraceabilityServicePort;
import com.backendchallenge.traceabilityservice.domain.spi.IOrderTraceabilityPersistencePort;
import com.backendchallenge.traceabilityservice.domain.usecase.OrderTraceabilityCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IOrderTraceabilityRepository orderTraceabilityRepository;
    private final IOrderEntityMapper orderEntityMapper;

    @Bean
    public IOrderTraceabilityServicePort orderTraceabilityServicePort(){
        return new OrderTraceabilityCase(orderTraceabilityPersistencePort());
    }

    @Bean
    public IOrderTraceabilityPersistencePort orderTraceabilityPersistencePort(){
        return new OrderTraceabilityJpaAdapter(orderEntityMapper, orderTraceabilityRepository);
    }
}

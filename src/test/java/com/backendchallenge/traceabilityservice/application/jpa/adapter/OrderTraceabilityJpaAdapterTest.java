package com.backendchallenge.traceabilityservice.application.jpa.adapter;

import com.backendchallenge.traceabilityservice.application.jpa.entity.OrderEntity;
import com.backendchallenge.traceabilityservice.application.jpa.mapper.IOrderEntityMapper;
import com.backendchallenge.traceabilityservice.application.jpa.repository.IOrderTraceabilityRepository;
import com.backendchallenge.traceabilityservice.domain.model.Order;
import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderTraceabilityJpaAdapterTest {

    @Mock
    private IOrderEntityMapper orderEntityMapper;

    @Mock
    private IOrderTraceabilityRepository orderTraceabilityRepository;

    @InjectMocks
    private OrderTraceabilityJpaAdapter orderTraceabilityJpaAdapter;

    AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @Test
    void createOrderTraceability_validOrder_savesOrderEntity() {
        Order order = new Order(ConstTest.ID_TEST,ConstTest.ID_TEST,ConstTest.ID_TEST,ConstTest.ID_TEST,
                new ArrayList<>(),new ArrayList<>());
        OrderEntity orderEntity = new OrderEntity(ConstTest.ID_TEST.toString(),ConstTest.ID_TEST,ConstTest.ID_TEST,ConstTest.ID_TEST,
                new ArrayList<>(),new ArrayList<>());
        when(orderEntityMapper.toEntity(order)).thenReturn(orderEntity);

        orderTraceabilityJpaAdapter.createOrderTraceability(order);

        verify(orderTraceabilityRepository, times(ConstValidation.ONE)).save(orderEntity);
    }


    @Test
    void getOrderByOrderId_validId_returnsOrder() {
        Long idOrder = ConstTest.ID_TEST;
        String id = idOrder.toString();
        Order order = new Order();
        when(orderTraceabilityRepository.findById(id)).thenReturn(order);

        Order result = orderTraceabilityJpaAdapter.getOrderByOrderId(idOrder);

        assertEquals(order, result);
    }
    @Test
    void getAllOrders_returnsOrderList() {
        List<OrderEntity> orderEntities = new ArrayList<>();
        orderEntities.add(new OrderEntity());
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        when(orderTraceabilityRepository.findAll()).thenReturn(orderEntities);
        when(orderEntityMapper.toDomainList(orderEntities)).thenReturn(orders);

        List<Order> result = orderTraceabilityJpaAdapter.getAllOrders();

        assertEquals(orders, result);
    }
}
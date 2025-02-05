package com.backendchallenge.traceabilityservice.domain.model;

import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void constructor_initializesFieldsCorrectly() {
        List<OrderedDish> dishes = new ArrayList<>();
        List<StatusChange> statusChanges = new ArrayList<>();
        Order order = new Order(ConstTest.ID_TEST, ConstTest.ID_TEST, ConstTest.ID_TEST, ConstTest.ID_TEST, dishes, statusChanges);

        assertEquals(ConstTest.ID_TEST, order.getId());
        assertEquals(ConstTest.ID_TEST, order.getIdClient());
        assertEquals(ConstTest.ID_TEST, order.getIdEmployee());
        assertEquals(ConstTest.ID_TEST, order.getIdRestaurant());
        assertEquals(dishes, order.getDishes());
        assertEquals(statusChanges, order.getStatusChanges());
    }

    @Test
    void setId_updatesIdField() {
        Order order = new Order();
        order.setId(ConstTest.ID_TEST);

        assertEquals(ConstTest.ID_TEST, order.getId());
    }

    @Test
    void setIdClient_updatesIdClientField() {
        Order order = new Order();
        order.setIdClient(ConstTest.ID_TEST);

        assertEquals(ConstTest.ID_TEST, order.getIdClient());
    }

    @Test
    void setIdEmployee_updatesIdEmployeeField() {
        Order order = new Order();
        order.setIdEmployee(ConstTest.ID_TEST);

        assertEquals(ConstTest.ID_TEST, order.getIdEmployee());
    }

    @Test
    void setIdRestaurant_updatesIdRestaurantField() {
        Order order = new Order();
        order.setIdRestaurant(ConstTest.ID_TEST);

        assertEquals(ConstTest.ID_TEST, order.getIdRestaurant());
    }

    @Test
    void setDishes_updatesDishesField() {
        Order order = new Order();
        List<OrderedDish> dishes = new ArrayList<>();
        order.setDishes(dishes);

        assertEquals(dishes, order.getDishes());
    }

    @Test
    void setStatusChanges_updatesStatusChangesField() {
        Order order = new Order();
        List<StatusChange> statusChanges = new ArrayList<>();
        order.setStatusChanges(statusChanges);

        assertEquals(statusChanges, order.getStatusChanges());
    }
}
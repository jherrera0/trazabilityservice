package com.backendchallenge.traceabilityservice.domain.model;

import com.backendchallenge.traceabilityservice.domain.until.ConstTest;
import com.backendchallenge.traceabilityservice.domain.until.ConstValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderedDishTest {

    @Test
    void constructor_initializesFieldsCorrectly() {
        OrderedDish orderedDish = new OrderedDish(ConstTest.ID_TEST, ConstTest.ID_TEST, ConstValidation.ONE);

        assertEquals(ConstTest.ID_TEST, orderedDish.getId());
        assertEquals(ConstTest.ID_TEST, orderedDish.getIdDish());
        assertEquals(ConstValidation.ONE, orderedDish.getQuantity());
    }

    @Test
    void setId_updatesIdField() {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setId(ConstTest.ID_TEST);

        assertEquals(ConstTest.ID_TEST, orderedDish.getId());
    }

    @Test
    void setIdDish_updatesIdDishField() {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setIdDish(ConstTest.ID_TEST);

        assertEquals(ConstTest.ID_TEST, orderedDish.getIdDish());
    }

    @Test
    void setQuantity_updatesQuantityField() {
        OrderedDish orderedDish = new OrderedDish();
        orderedDish.setQuantity(ConstValidation.ONE);

        assertEquals(ConstValidation.ONE, orderedDish.getQuantity());
    }
}
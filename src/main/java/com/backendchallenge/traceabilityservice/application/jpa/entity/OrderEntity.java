package com.backendchallenge.traceabilityservice.application.jpa.entity;

import com.backendchallenge.traceabilityservice.domain.model.OrderedDish;
import com.backendchallenge.traceabilityservice.domain.model.StatusChange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {
    @Id
    private Long id;
    private Long idClient;
    private Long idEmployee;
    private Long idRestaurant;
    private List<OrderedDish> dishes;
    private List<StatusChange> statusChanges;
}

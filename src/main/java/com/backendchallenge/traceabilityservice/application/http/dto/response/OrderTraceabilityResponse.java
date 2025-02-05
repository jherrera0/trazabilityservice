package com.backendchallenge.traceabilityservice.application.http.dto.response;

import com.backendchallenge.traceabilityservice.domain.model.OrderedDish;
import com.backendchallenge.traceabilityservice.domain.model.StatusChange;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTraceabilityResponse {
    private Long id;
    private Long idClient;
    private Long idEmployee;
    private Long idRestaurant;
    private List<OrderedDish> dishes;
    private List<StatusChange> statusChanges;
}

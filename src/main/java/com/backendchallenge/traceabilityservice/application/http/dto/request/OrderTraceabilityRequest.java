package com.backendchallenge.traceabilityservice.application.http.dto.request;

import com.backendchallenge.traceabilityservice.domain.model.OrderedDish;
import com.backendchallenge.traceabilityservice.domain.model.StatusChange;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderTraceabilityRequest {
    @Positive
    @NotNull
    private Long id;
    @Positive
    @NotNull
    private Long idClient;
    @Positive
    @NotNull
    private Long idEmployee;
    @Positive
    @NotNull
    private Long idRestaurant;
    @NotNull
    private List<OrderedDish> dishes;
    @NotNull
    private List<StatusChange> statusChanges;
}

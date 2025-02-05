package com.backendchallenge.traceabilityservice.application.http.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignEmployeeToOrderTraceabilityRequest {
    @Positive
    @NotNull
    private Long orderId;
    @Positive
    @NotNull
    private Long employeeId;
}

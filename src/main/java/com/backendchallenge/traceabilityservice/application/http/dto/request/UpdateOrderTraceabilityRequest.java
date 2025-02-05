package com.backendchallenge.traceabilityservice.application.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateOrderTraceabilityRequest {
    @Positive
    @NotNull
    private Long idOrder;
    @NotNull
    @NotBlank
    private String status;
    @NotNull
    private LocalDateTime date;
}

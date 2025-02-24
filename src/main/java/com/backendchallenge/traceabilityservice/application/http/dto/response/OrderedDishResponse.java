package com.backendchallenge.traceabilityservice.application.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderedDishResponse {
    private Long idDish;
    private Integer quantity;
}

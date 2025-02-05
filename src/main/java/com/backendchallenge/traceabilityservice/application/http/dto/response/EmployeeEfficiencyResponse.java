package com.backendchallenge.traceabilityservice.application.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEfficiencyResponse {
    private Long employeeId;
    private double averageTime;
}

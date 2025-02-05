package com.backendchallenge.traceabilityservice.domain.model;

public class EmployeeEfficiency {
    private Long employeeId;
    private double averageTime;

    public EmployeeEfficiency() {
    }

    public EmployeeEfficiency(Long employeeId, double averageTime) {
        this.employeeId = employeeId;
        this.averageTime = averageTime;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public double getAverageTime() {
        return averageTime;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setAverageTime(double averageTime) {
        this.averageTime = averageTime;
    }

}

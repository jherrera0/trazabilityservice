package com.backendchallenge.traceabilityservice.domain.model;

public class OrderEfficiency {
    private Long orderId;
    private Long employeeId;
    private long processingTimeMinutes;

    public OrderEfficiency() {
    }

    public OrderEfficiency(Long orderId, Long employeeId, long processingTimeMinutes) {
        this.orderId = orderId;
        this.employeeId = employeeId;
        this.processingTimeMinutes = processingTimeMinutes;
    }

    public Long getOrderId() {
        return orderId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public long getProcessingTimeMinutes() {
        return processingTimeMinutes;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    
    public void setProcessingTimeMinutes(long processingTimeMinutes) {
        this.processingTimeMinutes = processingTimeMinutes;
    }


}

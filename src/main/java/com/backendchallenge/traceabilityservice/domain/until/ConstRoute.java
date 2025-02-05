package com.backendchallenge.traceabilityservice.domain.until;

public class ConstRoute {
    public static final String TRACEABILITY = "/traceability";
    public static final String CREATE_ORDER_TRACEABILITY = "/createOrderTraceability";
    public static final String UPDATE_ORDER_TRACEABILITY = "/updateOrderTraceability";
    public static final String ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY = "/assignEmployeeToOrderTraceability";
    public static final String GET_ORDER_TRACEABILITY_BY_ID = "/getOrderTraceabilityById";
    public static final String GET_EFFICIENCY_ORDERS = "/ordersEfficiency";
    public static final String GET_EFFICIENCY_EMPLOYEES = "/employeesEfficiency";

    private ConstRoute() {
    }
}

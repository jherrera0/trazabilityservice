package com.backendchallenge.traceabilityservice.domain.until;

public class ConstDocumentation {

    public static final String TRACEABILITY_REST_NAME = "Traceability";
    public static final String TRACEABILITY_REST_DESCRIPTION
            = "This service is responsible for tracking the status of the requests";
    public static final String CREATE_ORDER_TRACEABILITY_OPERATION = "Create Order Traceability";
    public static final String CODE_201 = "201";
    public static final String CODE_400 = "400";
    public static final String CODE_403 = "403";
    public static final String CREATE_ORDER_TRACEABILITY_CODE_201 = "Order traceability created successfully";
    public static final String CREATE_ORDER_TRACEABILITY_CODE_400 = "Invalid request";
    public static final String CREATE_ORDER_TRACEABILITY_CODE_403 = "Forbidden request";
    public static final String UPDATE_ORDER_TRACEABILITY_OPERATION = "Update Order Traceability";
    public static final String UPDATE_ORDER_TRACEABILITY_CODE_201 = "Order traceability updated successfully";
    public static final String UPDATE_ORDER_TRACEABILITY_CODE_400 = "Invalid request";
    public static final String UPDATE_ORDER_TRACEABILITY_CODE_403 = "Forbidden request";
    public static final String ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_OPERATION = "Assign Employee to Order Traceability";
    public static final String ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_CODE_201 = "Employee assigned to order traceability successfully";
    public static final String ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_CODE_400 = "Invalid request";
    public static final String ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_CODE_403 = "Forbidden request";
    public static final String GET_ORDER_TRACEABILITY_BY_ID_OPERATION = "Get Order Traceability by ID";
    public static final String GET_ORDER_TRACEABILITY_BY_ID_CODE_201 = "Order traceability found successfully";
    public static final String GET_ORDER_TRACEABILITY_BY_ID_CODE_400 = "Invalid request";
    public static final String GET_ORDER_TRACEABILITY_BY_ID_CODE_403 = "Forbidden request";
    public static final String GET_EFFICIENCY_ORDER = "get efficiency of order";


    private ConstDocumentation() {
    }
}

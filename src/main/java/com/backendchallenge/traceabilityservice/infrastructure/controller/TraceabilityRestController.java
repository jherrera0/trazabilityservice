package com.backendchallenge.traceabilityservice.infrastructure.controller;

import com.backendchallenge.traceabilityservice.application.http.dto.request.AssignEmployeeToOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.OrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.dto.request.UpdateOrderTraceabilityRequest;
import com.backendchallenge.traceabilityservice.application.http.handler.interfaces.IOrderTraceabilityHandler;
import com.backendchallenge.traceabilityservice.domain.until.ConstDocumentation;
import com.backendchallenge.traceabilityservice.domain.until.ConstJwt;
import com.backendchallenge.traceabilityservice.domain.until.ConstRoute;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(ConstRoute.TRACEABILITY)
@Tag(name = ConstDocumentation.TRACEABILITY_REST_NAME, description = ConstDocumentation.TRACEABILITY_REST_DESCRIPTION)
public class TraceabilityRestController {
    private final IOrderTraceabilityHandler orderTraceabilityHandler;

    @Operation(summary = ConstDocumentation.CREATE_ORDER_TRACEABILITY_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstDocumentation.CODE_201,
                    description = ConstDocumentation.CREATE_ORDER_TRACEABILITY_CODE_201),
            @ApiResponse(responseCode = ConstDocumentation.CODE_400,
                    description = ConstDocumentation.CREATE_ORDER_TRACEABILITY_CODE_400),
            @ApiResponse(responseCode = ConstDocumentation.CODE_403,
                    description = ConstDocumentation.CREATE_ORDER_TRACEABILITY_CODE_403),
    })
    @PreAuthorize(ConstJwt.HAS_AUTHORITY_EMPLOYEE)
    @PostMapping(ConstRoute.CREATE_ORDER_TRACEABILITY)
    public ResponseEntity<Void> createOrderTraceability(@Valid @RequestBody OrderTraceabilityRequest request) {
        orderTraceabilityHandler.createOrderTraceability(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = ConstDocumentation.UPDATE_ORDER_TRACEABILITY_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstDocumentation.CODE_201,
                    description = ConstDocumentation.UPDATE_ORDER_TRACEABILITY_CODE_201),
            @ApiResponse(responseCode = ConstDocumentation.CODE_400,
                    description = ConstDocumentation.UPDATE_ORDER_TRACEABILITY_CODE_400),
            @ApiResponse(responseCode = ConstDocumentation.CODE_403,
                    description = ConstDocumentation.UPDATE_ORDER_TRACEABILITY_CODE_403),
    })
    @PreAuthorize(ConstJwt.HAS_AUTHORITY_EMPLOYEE)
    @PostMapping(ConstRoute.UPDATE_ORDER_TRACEABILITY)
    public ResponseEntity<Void> updateOrderTraceability(@Valid @RequestBody UpdateOrderTraceabilityRequest request) {
        orderTraceabilityHandler.updateOrderTraceability(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = ConstDocumentation.ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstDocumentation.CODE_201,
                    description = ConstDocumentation.ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_CODE_201),
            @ApiResponse(responseCode = ConstDocumentation.CODE_400,
                    description = ConstDocumentation.ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_CODE_400),
            @ApiResponse(responseCode = ConstDocumentation.CODE_403,
                    description = ConstDocumentation.ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY_CODE_403),
    })
    @PreAuthorize(ConstJwt.HAS_AUTHORITY_EMPLOYEE)
    @PostMapping(ConstRoute.ASSIGN_EMPLOYEE_TO_ORDER_TRACEABILITY)
    public ResponseEntity<Void> assignEmployeeToOrderTraceability(@Valid @RequestBody AssignEmployeeToOrderTraceabilityRequest request) {
        orderTraceabilityHandler.assignEmployeeToOrderTraceability(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = ConstDocumentation.GET_ORDER_TRACEABILITY_BY_ID_OPERATION)
    @ApiResponses(value = {
            @ApiResponse(responseCode = ConstDocumentation.CODE_201,
                    description = ConstDocumentation.GET_ORDER_TRACEABILITY_BY_ID_CODE_201),
            @ApiResponse(responseCode = ConstDocumentation.CODE_400,
                    description = ConstDocumentation.GET_ORDER_TRACEABILITY_BY_ID_CODE_400),
            @ApiResponse(responseCode = ConstDocumentation.CODE_403,
                    description = ConstDocumentation.GET_ORDER_TRACEABILITY_BY_ID_CODE_403),
    })
    @PreAuthorize(ConstJwt.HAS_AUTHORITY_CLIENT)
    @PostMapping(ConstRoute.GET_ORDER_TRACEABILITY_BY_ID)
    public ResponseEntity<Void> getOrderTraceabilityById(@Valid @RequestBody Long id) {
        orderTraceabilityHandler.getOrderTraceabilityById(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

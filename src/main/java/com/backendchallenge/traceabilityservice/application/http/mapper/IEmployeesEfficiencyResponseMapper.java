package com.backendchallenge.traceabilityservice.application.http.mapper;

import com.backendchallenge.traceabilityservice.application.http.dto.response.EmployeeEfficiencyResponse;
import com.backendchallenge.traceabilityservice.domain.model.EmployeeEfficiency;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IEmployeesEfficiencyResponseMapper {
    @Mapping(target = "employeeId",source = "employeeId")
    EmployeeEfficiencyResponse toResponse(EmployeeEfficiency employeeEfficiency);
    List<EmployeeEfficiencyResponse> toResponseList(List<EmployeeEfficiency> employeeEfficiencies);
}

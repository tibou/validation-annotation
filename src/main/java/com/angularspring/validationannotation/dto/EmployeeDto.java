package com.angularspring.validationannotation.dto;

import com.angularspring.validationannotation.enums.EmployeeType;
import com.angularspring.validationannotation.validators.NotNullIf;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@NotNullIf.List({
        @NotNullIf(referenceFieldName = "employeeType", referenceFieldValue = "FULL_TIME_EMPLOYEE", targetFieldName = "salary"),
        @NotNullIf(referenceFieldName = "employeeType", referenceFieldValue = "PART_TIME_EMPLOYEE", targetFieldName = "hourlyWage")
})
public class EmployeeDto {

    private Integer id;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
    private EmployeeType employeeType;
    private Double salary;    // Ce champs est NonNull si employeeType est FULL_TIME_EMPLOYEE
    private Double hourlyWage; // Ce champs est NonNull si employeeType est PART_TIME_EMPLOYEE
}

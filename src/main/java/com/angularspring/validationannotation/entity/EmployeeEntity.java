package com.angularspring.validationannotation.entity;

import com.angularspring.validationannotation.enums.EmployeeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String firstname;
    private String lastname;
    private EmployeeType employeeType;
    private Double salary;
    private Double hourlyWage;
}

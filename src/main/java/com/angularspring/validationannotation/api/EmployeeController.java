package com.angularspring.validationannotation.api;

import com.angularspring.validationannotation.dto.EmployeeDto;
import com.angularspring.validationannotation.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto){

        EmployeeDto employeeDtoToReturn = this.employeeService.save(employeeDto);

        return new ResponseEntity<>(employeeDtoToReturn, HttpStatus.CREATED);
    }
}

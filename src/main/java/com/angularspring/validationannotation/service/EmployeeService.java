package com.angularspring.validationannotation.service;

import com.angularspring.validationannotation.dto.EmployeeDto;
import com.angularspring.validationannotation.entity.EmployeeEntity;
import com.angularspring.validationannotation.mapper.EmployeeMapper;
import com.angularspring.validationannotation.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    private static final Set<EmployeeEntity> employees = new HashSet<>();

    public EmployeeDto save(EmployeeDto employeeDto){

        EmployeeEntity employee = employeeMapper.toEmployeeEntity(employeeDto);
        EmployeeEntity savedEmployee = employeeRepository.save(employee);

        return this.employeeMapper.toEmployeeDto(savedEmployee);
    }
}

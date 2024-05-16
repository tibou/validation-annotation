package com.angularspring.validationannotation.mapper;

import com.angularspring.validationannotation.dto.EmployeeDto;
import com.angularspring.validationannotation.entity.EmployeeEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    ModelMapper modelMapper = new ModelMapper();

    public EmployeeEntity toEmployeeEntity(EmployeeDto employeeDto){
        return modelMapper.map(employeeDto, EmployeeEntity.class);
    }

    public EmployeeDto toEmployeeDto(EmployeeEntity employee){
        return modelMapper.map(employee, EmployeeDto.class);
    }

}

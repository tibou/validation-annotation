package com.angularspring.validationannotation.enums;

public enum EmployeeType {
    FULL_TIME_EMPLOYEE ("Employé à plein temps"),
    PART_TIME_EMPLOYEE ("Employé à temps partiel");

    private final String label;

    EmployeeType(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

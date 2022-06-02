package com.bridgelabz.employeepayrollapp.model;

/**
 * Use to simplify the code and reduce the boiler plate code for getter-setter method etc.
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * EmployeeData class is Defining the attributes of the Employee  and getting and setting the values/parameters in them.
 */
@Getter
@Setter
@Entity
public class EmployeePayrollData {
    @Id
    private long employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData(){}

    public EmployeePayrollData(long empId, EmployeePayrollDTO employeePayrollDTO){
        this.employeeId=empId;
        this.name=employeePayrollDTO.name;
        this.salary=employeePayrollDTO.salary;
    }
}

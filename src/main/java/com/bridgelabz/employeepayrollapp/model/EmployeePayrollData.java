package com.bridgelabz.employeepayrollapp.model;

/**
 * Use to simplify the code and reduce the boiler plate code for getter-setter method etc.
 */

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * EmployeeData class is Defining the attributes of the Employee  and getting and setting the values/parameters in them.
 */
@Data
@ToString
@Table(name = "EmployeePayroll")
@Entity
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employeeId;

    private String name;

    private long salary;

    public EmployeePayrollData() {

    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {

        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }

}
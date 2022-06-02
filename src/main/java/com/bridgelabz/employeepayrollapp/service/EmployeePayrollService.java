package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    /**
     * Method to get employee data.
     *
     * @return : Returing employee data list.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = new ArrayList<>();
        empDataList.add(new EmployeePayrollData(1, new EmployeePayrollDTO("archana", 4000)));
        return empDataList;
    }

    /**
     * Method to get employee payroll.
     *
     * @param empId :Passing empId as input.
     * @return : returning employee data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(long empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1,
                new EmployeePayrollDTO("archana", 5000));
        return empData;
    }

    /**
     * Method to create employee payroll.
     *
     * @param employeePayrollDTO : Passing employeePayrollDTO as input.
     * @return Returning payroll data.
     */
    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        return empData;
    }

    /**
     * Method to update employee payroll.
     *
     * @param employeePayrollDTO :Passing employeePayrollDTO as input.
     * @return : Returing updated employee data.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, employeePayrollDTO);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(long empId) {

    }
}

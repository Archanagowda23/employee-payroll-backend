package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    private  List<EmployeePayrollData> empDataList = new ArrayList<>();

    /**
     * Method to get employee data.
     *
     * @return : Returing employee data list.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    /**
     * Method to get employee payroll.
     *
     * @param empId :Passing empId as input.
     * @return : returning employee data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById(empId).orElseThrow(()->new EmployeePayrollException("Employee Not Found"));
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
        empData = new EmployeePayrollData(employeePayrollDTO);
        employeeRepository.save(empData);
        return empData;
    }

    /**
     * Method to update employee payroll.
     *
     * @param employeePayrollDTO :Passing employeePayrollDTO as input.
     * @return : Returing updated employee data.
     */
    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeeRepository.save(empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(empData);
    }
}

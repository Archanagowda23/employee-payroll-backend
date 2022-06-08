package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
        return employeeRepository.findById(empId)
                .orElseThrow(()->new EmployeePayrollException(("Employee with employeeOd "+empId+ "does not exists...")));
    }

    @Override
    public List<EmployeePayrollData> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
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
        empDataList.add(empData);//adds in employee list
        log.debug("Emp Data: "+empData.toString());
        return employeeRepository.save(empData);
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
        empData.updateEmployeePayrollData(employeePayrollDTO);
        return employeeRepository.save(empData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(employeePayrollData);
    }
}

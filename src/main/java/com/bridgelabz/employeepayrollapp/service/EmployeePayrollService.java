package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    private  List<EmployeePayrollData> empDataList = new ArrayList<>();

    /**
     * Method to get employee data.
     *
     * @return : Returing employee data list.
     */
    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        return empDataList;
    }

    /**
     * Method to get employee payroll.
     *
     * @param empId :Passing empId as input.
     * @return : returning employee data.
     */
    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
    return empDataList.get(empId-1);
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
        empData = new EmployeePayrollData(empDataList.size()+1,employeePayrollDTO);
        empDataList.add(empData);
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
        empData.setName(employeePayrollDTO.name);
        empData.setSalary(employeePayrollDTO.salary);
        empDataList.set(empId-1, empData);
        return empData;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        empDataList.remove(empId-1);
    }
}

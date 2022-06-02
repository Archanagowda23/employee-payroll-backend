package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller Class
 * URL - http://localhost:8081/employee
 */
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    /**
     * Method to get the Employee Details to the Given table as Entity.
     * @return Get the Data given by the user to the table.
     */
    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, new EmployeePayrollDTO("archana", 3000));
        ResponseDTO respDTO = new ResponseDTO("Get call Success", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Method to get the Employee Details of the given Employee ID.
     * @param empId :Passed by the user.
     * @return : Get the Data given by the user to the table.
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrolIData(@PathVariable(value = "empId") int empId) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, new EmployeePayrollDTO("archana", 3000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Success for id: ", employeePayrollData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Method to create the Employee Data.
     * @param empPayrollDTO :Passed by the user.
     * @return : created data.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(1, empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     * Method to update the Employee Data of the given Employee ID.
     * @param empId :Passed by the user.
     * @param empPayrollDTO :Passed by the user.
     * @return : updated data and get Updated employee Payroll data successfully message in string type.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable int empId, @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = null;
        employeePayrollData = new EmployeePayrollData(empId, empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee Payroll data successfully", employeePayrollData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     *  Method to remove the Employee Data of the given Employee ID.
     * @param empId :Passed by the user.
     * @return :Deleted Successful Message in String Type.
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully", "Deleted id: " + empId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

package com.bridgelabz.employeepayrollapp.controller;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller Class
 * URL - http://localhost:8081/employee
 */
@RequestMapping("/employeepayroll")
@RestController
public class EmployeeController {

    @Autowired
    private IEmployeePayrollService employeePayrollService;


    /**
     * Method to get the Employee Details to the Given table as Entity.
     * @return Get the Data given by the user to the table.
     */
    @RequestMapping(value = {"", "/", "/getInfo"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        List<EmployeePayrollData> empDataList = null;
        empDataList = employeePayrollService.getEmployeePayrollData();
        ResponseDTO responseDTO = new ResponseDTO("Get Call Successfull.",empDataList);
        return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);
    }


    /**
     * Method to get the Employee Details of the given Employee ID.
     * @param empId :Passed by the user.
     * @return : Get the Data given by the user to the table.
     */
    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayrolIDataById(@PathVariable long empId){
        EmployeePayrollData empData = null;
        empData = employeePayrollService.getEmployeePayrollDataById(1);
        ResponseDTO respDTO = new ResponseDTO("Get Call Success for id: ", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    /**
     * Method to create the Employee Data.
     * @param empPayrollDTO :Passed by the user.
     * @return : created data.
     */
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayrollData(@RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Created employee Payroll data successfully", empData);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.CREATED);
    }

    /**
     * Method to update the Employee Data of the given Employee ID.
     * @param empPayrollDTO :Passed by the user.
     * @return : updated data and get Updated employee Payroll data successfully message in string type.
     */
    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@PathVariable("empId") int empId, @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = employeePayrollService.updateEmployeePayrollData(empId,empPayrollDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated employee Payroll data successfully", empData);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    /**
     *  Method to remove the Employee Data of the given Employee ID.
     * @param empId :Passed by the user.
     * @return :Deleted Successful Message in String Type.
     */

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId") int empId) {
        employeePayrollService.deleteEmployeePayrollData(empId);
        ResponseDTO responseDTO = new ResponseDTO("Deleted successfully", "Deleted id: " + empId);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}

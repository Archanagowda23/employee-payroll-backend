package com.bridgelabz.employeepayrollapp.controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @GetMapping("/getMessage")
    public String  welcomeMessage(){
        return " Welcome to Employee Payroll";
    }
}
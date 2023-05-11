package com.example.employeeservice.controller;

import com.example.employeeservice.dao.EmployeeDao;
import com.example.employeeservice.dto.EmployeeDto;
import com.example.employeeservice.dto.Employees;
import com.example.employeeservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @GetMapping("/employees")
    public Employees listAllEmployees(){
        List<EmployeeDto> employeeDtoList=employeeDao.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return new Employees(employeeDtoList);
    }
    private EmployeeDto toDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getCubicleNo(),
                employee.getSalary()
        );
    }
}

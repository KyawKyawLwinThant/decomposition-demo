package com.example.employeeservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class Employees {

    private List<EmployeeDto> employeeDtos;

    public Employees(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }
}

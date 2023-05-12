package com.example.webui.dto;

import lombok.Data;

import java.util.List;

@Data
public class Employees {

    private List<EmployeeDto> employeeDtos;
    public Employees(){}

    public Employees(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }
}

package com.example.employeeservice.dto;

import lombok.Data;

@Data
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String cubicleNo;
    private double salary;

    private final int count;



    public EmployeeDto(Integer id, String firstName, String lastName, String cubicleNo, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cubicleNo = cubicleNo;
        this.salary = salary;
        count=4;
    }

    public EmployeeDto(){
        final int test;
        test=6;
        count=7;

    }

}

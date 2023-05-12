package com.example.webui.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String cubicleNo;
    private double salary;

    public EmployeeDto(){}




    public EmployeeDto(Integer id, String firstName, String lastName, String cubicleNo, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cubicleNo = cubicleNo;
        this.salary = salary;

    }



}

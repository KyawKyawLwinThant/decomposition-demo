package com.example.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String cubicleNo;
    private double salary;

    public Employee(String firstName, String lastName, String cubicleNo, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cubicleNo = cubicleNo;
        this.salary = salary;
    }

    public Employee(){

    }
}

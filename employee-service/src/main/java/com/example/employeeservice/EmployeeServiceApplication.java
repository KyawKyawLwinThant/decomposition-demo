package com.example.employeeservice;

import com.example.employeeservice.dao.EmployeeDao;
import com.example.employeeservice.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class EmployeeServiceApplication {
    @Autowired
    private EmployeeDao employeeDao;
    //Employee(String firstName, String lastName, String cubicleNo, double salary) {
    @Transactional
    @Bean @Profile("dev")
    public ApplicationRunner runner(){
        return r ->{
            Employee e1=new Employee("John","Doe","EO1",3000);
            Employee e2=new Employee("John","William","EO2",2500);
            Employee e3=new Employee("Thomas","Hardy","EO3",4000);
            employeeDao.save(e1);
            employeeDao.save(e2);
            employeeDao.save(e3);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(EmployeeServiceApplication.class, args);
    }

}

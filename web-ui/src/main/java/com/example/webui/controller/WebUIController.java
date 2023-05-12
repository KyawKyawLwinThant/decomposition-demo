package com.example.webui.controller;

import com.example.webui.dto.AddressDto;
import com.example.webui.dto.Addresses;
import com.example.webui.dto.EmployeeDto;
import com.example.webui.dto.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("webui")
public class WebUIController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping({"/","/home"})
    public String home(Model model){
        List<EmployeeDto> employees=new ArrayList<>();
        model.addAttribute("addresses",addressDtos);
        model.addAttribute("employees",employeeDtos);
        return "home";
    }
    List<AddressDto> addressDtos=new ArrayList<>();
    List<EmployeeDto>  employeeDtos=new ArrayList<>();
    @GetMapping("/employees")
    public String listAllEmployees(Model model){
        ResponseEntity<Employees> employeesResponseEntity=
                restTemplate
                        .getForEntity("http://localhost:8080/employee/employees",
                                Employees.class);

        if(employeesResponseEntity.getStatusCode().is2xxSuccessful()){
            this.employeeDtos=employeesResponseEntity
                    .getBody()
                    .getEmployeeDtos();
            return "forward:/webui/home";
        }else{
            model.addAttribute("employees",List.of());
            return "forward:/webui/home";
        }
    }

    @GetMapping("/addresses")
    public String listAllAddress(Model model){
        ResponseEntity<Addresses> addressResponse = restTemplate
                .getForEntity("http://localhost:8080/address/addresses",
                Addresses.class);
        if(addressResponse.getStatusCode().is2xxSuccessful()){
            this.addressDtos=addressResponse
                    .getBody()
                    .getAddresses();
            return "forward:/webui/home";
        }
        else {
            model.addAttribute("addresses", List.of());
            return "forward:/webui/home";
        }

    }

}

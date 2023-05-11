package com.example.webui.controller;

import com.example.webui.dto.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
@RequestMapping("webui")
public class WebUIController {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping({"/","/home"})
    public String home(Model model){
        model.addAttribute("addresses", List.of());
        return "home";
    }
    @GetMapping("/addresses")
    public String listAllAddress(Model model){
        ResponseEntity<Addresses> addressResponse = restTemplate
                .getForEntity("http://localhost:9090/address/addresses",
                Addresses.class);
        if(addressResponse.getStatusCode().is2xxSuccessful()){
            model.addAttribute("addresses",addressResponse
                    .getBody()
                    .getAddresses());
            return "home";
        }
        else {
            model.addAttribute("addresses", List.of());
            return "home";
        }

    }

}

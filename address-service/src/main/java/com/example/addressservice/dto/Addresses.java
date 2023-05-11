package com.example.addressservice.dto;

import com.example.addressservice.entity.Address;
import lombok.Data;

import java.util.List;

@Data
public class Addresses {
    private List<Address> addresses;

    public Addresses(){}

    public Addresses(List<Address> addresses){
        this.addresses=addresses;
    }
}

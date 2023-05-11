package com.example.webui.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int id;
    private String streetName;
    private String streetNumber;
    private String city;
    private String zipCode;
    public AddressDto(){

    }

    public AddressDto(int id, String streetName, String streetNumber, String city, String zipCode) {
        this.id = id;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.zipCode = zipCode;
    }
}

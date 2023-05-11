package com.example.addressservice;

import com.example.addressservice.dao.AddressDao;
import com.example.addressservice.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class AddressServiceApplication {
    @Autowired
    private AddressDao addressDao;
    @Transactional
    @Bean @Profile("test")
    public ApplicationRunner runner( ){
        return r ->{
            Address address1=new Address("dream land","799","Mdy","111111");
            Address address2=new Address("blue lagoon","999","Mdy","222222");
            Address address3=new Address("creek bridge road","256","Ygn","333333");
            Address address4=new Address("Park Avenue","79","Ygn","555555");
            addressDao.save(address1);
            addressDao.save(address2);
            addressDao.save(address3);
            addressDao.save(address4);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceApplication.class, args);
    }

}

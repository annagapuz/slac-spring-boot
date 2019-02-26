package com.gaps.sample.boot.controller;

import com.gaps.sample.boot.entity.Address;
import com.gaps.sample.boot.entity.AddressBook;
import com.gaps.sample.boot.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class SampleController {

    @Autowired
    AddressBookRepository addressBookRepository;

    @GetMapping("/load")
    public void loadData() {
        AddressBook book = new AddressBook();
        book.setName("My H2 Address Book");

        Address address1 = new Address();
        address1.setStreet("123 Main Street");
        address1.setCity("Reston");
        address1.setState("VA");

        Address address2 = new Address();
        address2.setStreet("123 Foo Blvd");
        address2.setCity("Baltimore");
        address2.setState("MD");

        book.setAddress(Arrays.asList(address1, address2));

        addressBookRepository.save(book);
    }
}

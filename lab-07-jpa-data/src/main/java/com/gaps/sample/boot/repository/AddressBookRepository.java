package com.gaps.sample.boot.repository;

import com.gaps.sample.boot.entity.AddressBook;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {

    List<AddressBook> findByAddress_State(String state);

}

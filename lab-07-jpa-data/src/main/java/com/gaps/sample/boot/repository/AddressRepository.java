package com.gaps.sample.boot.repository;

import com.gaps.sample.boot.entity.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

    Address findFirstByCityStartsWith(String startingLetter);
}

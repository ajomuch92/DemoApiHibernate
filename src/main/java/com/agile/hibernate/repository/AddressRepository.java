package com.agile.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agile.hibernate.classes.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}

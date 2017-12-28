package com.agile.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.agile.hibernate.classes.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}

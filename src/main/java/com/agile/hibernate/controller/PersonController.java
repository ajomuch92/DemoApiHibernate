package com.agile.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agile.hibernate.classes.Person;
import com.agile.hibernate.exception.PersonNotFoundException;
import com.agile.hibernate.services.PersonService;

@RestController
@RequestMapping(path="/persons")
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@GetMapping("")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@PostMapping("")
	public Person addPerson(@RequestBody Person person) {
		return personService.addPerson(person);
	}
	
	@GetMapping("/{id}")
	public Person getOnePerson(@PathVariable int id) throws PersonNotFoundException{
		return personService.getOnePerson(id);
	}
	
	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable int id,@RequestBody Person person) throws PersonNotFoundException {
		return personService.updatePerson(id,person);
	}
	
	@DeleteMapping("/{id}")
	public boolean deletePerson(@PathVariable int id) throws PersonNotFoundException {
		return personService.updatePerson(id);
	}
}

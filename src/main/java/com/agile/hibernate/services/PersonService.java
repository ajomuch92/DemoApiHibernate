package com.agile.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.hibernate.classes.Person;
import com.agile.hibernate.exception.PersonNotFoundException;
import com.agile.hibernate.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public Person addPerson(Person person) {
		return personRepository.save(person);
	}

	public Person updatePerson(int id, Person person) throws PersonNotFoundException {
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		person.setIdPerson(id);
		return personRepository.save(person);
	}

	public boolean updatePerson(int id) throws PersonNotFoundException {
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		personRepository.delete(id);
		return true;
	}

	public Person getOnePerson(int id) throws PersonNotFoundException {
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		return personRepository.findOne(id);
	}
	
	
}

package com.agile.hibernate.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.hibernate.classes.Address;
import com.agile.hibernate.exception.AddressNotFoundException;
import com.agile.hibernate.exception.PersonNotFoundException;
import com.agile.hibernate.repository.AddressRepository;
import com.agile.hibernate.repository.PersonRepository;

@Service
public class AddressService {

	@Autowired
	AddressRepository addressRepository;
	@Autowired
	PersonRepository personRepository;
	
	public List<Address> getAllAdresses(int id) throws PersonNotFoundException{
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		return personRepository.getOne(id).getListAddresses();
	}

	public Address addAdress(int id, Address address) throws PersonNotFoundException {
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		address.setPerson(personRepository.getOne(id));
		return addressRepository.save(address);
	}

	public Address updateAdress(int id, int idAddress, Address address) throws PersonNotFoundException, AddressNotFoundException {
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		if(!addressRepository.exists(idAddress))
			throw new AddressNotFoundException(idAddress);
		address.setIdAddress(idAddress);
		address.setPerson(personRepository.getOne(id));
		return addressRepository.save(address);
	}

	public boolean deleteAdress(int id, int idAddress) throws PersonNotFoundException, AddressNotFoundException {
		if(!personRepository.exists(id))
			throw new PersonNotFoundException(id);
		if(!addressRepository.exists(idAddress))
			throw new AddressNotFoundException(idAddress);
		addressRepository.delete(idAddress);
		return true;
	}
}

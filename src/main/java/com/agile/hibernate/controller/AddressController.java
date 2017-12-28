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

import com.agile.hibernate.classes.Address;
import com.agile.hibernate.exception.AddressNotFoundException;
import com.agile.hibernate.exception.PersonNotFoundException;
import com.agile.hibernate.services.AddressService;

@RestController
@RequestMapping("/persons/{id}/")
public class AddressController {

	@Autowired
	AddressService addressService;
	
	@GetMapping("addresses")
	public List<Address> getAllAdresses(@PathVariable int id) throws PersonNotFoundException{
		return addressService.getAllAdresses(id);
	}
	
	@PostMapping("addresses")
	public Address addAdress(@PathVariable int id, @RequestBody Address address) throws PersonNotFoundException{
		return addressService.addAdress(id, address);
	}
	
	@PutMapping("addresses/{idAddress}")
	public Address updateAdress(@PathVariable int id, @PathVariable int idAddress, @RequestBody Address address) throws PersonNotFoundException, AddressNotFoundException{
		return addressService.updateAdress(id, idAddress, address);
	}
	
	@DeleteMapping("addresses/{idAddress}")
	public boolean deleteAdress(@PathVariable int id, @PathVariable int idAddress) throws PersonNotFoundException, AddressNotFoundException{
		return addressService.deleteAdress(id, idAddress);
	}
}

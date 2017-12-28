package com.agile.hibernate.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="idAddress")
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue
	@Column(name="id_address")
	private int idAddress;
	
	@Column(name="street",length=100,nullable=false)
	private String street;
	
	@Column(name="city",length=100,nullable=false)
	private String city;
	
	@ManyToOne(optional=false)
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Person person;
}

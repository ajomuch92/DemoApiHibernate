package com.agile.hibernate.classes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(exclude="idPerson")
@Entity
@Table(name="people")
public class Person {
	
	@Id
	@GeneratedValue
	@Column(name="id_person")
	private int idPerson;
	@Column(name="name",length=100,nullable=false)
	private String name;
	@Column(name="phone",length=50,nullable=false)
	private String phone;
	@Column(name="birth_date",nullable=false)
	private Date birthDate;
	
	@OneToMany(mappedBy="person")
	private List<Address> listAddresses;
}

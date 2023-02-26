package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
/**
 * @author andrewmccoy - agmccoy
 * CIS175 - Fall 2021
 * Jan 29, 2023
 */
public class Contacts {
	@Id
	@GeneratedValue
	//vars
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="PHONENUMBER")
	private String phoneNumber;
	@Column(name="ADDRESS")
	private String address;	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Pets> pets;
	
	//constructors
	public Contacts() {
		super();
	}
	public Contacts(String _name, String _phoneNumber, String _address) {
		this.name = _name;
		this.phoneNumber = _phoneNumber;
		this.address = _address;
	}
	public Contacts(String _name, String _phoneNumber, String _address, List<Pets> _pets) {
		this.name = _name;
		this.phoneNumber = _phoneNumber;
		this.address = _address;
		this.pets = _pets;
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Pets> getPets() {
		return pets;
	}
	public void setPets(List<Pets> pets) {
		this.pets = pets;
	}
	
	
	//helper methods
	public String returnContactInfo() {		
		return "Name : " + this.name + ", Phone Number: "
				+ this.phoneNumber + ", Address: " + this.address;
	}
	
}

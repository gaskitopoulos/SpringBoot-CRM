package com.example.demo.domainlayer;

import jakarta.persistence.*;

@Entity(name = "contacts")
public class Contact 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	
	public String firstname;
	public String lastname;
	public String mobile;
	public String phone;
	@Column(unique=true)
	public String afm;
	public String doy;
	public String adt; 
	public String address;
	public String tk;
	public String city;
	public String email;
	public String type;
}

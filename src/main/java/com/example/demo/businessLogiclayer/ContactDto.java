package com.example.demo.businessLogiclayer;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.*;

public class ContactDto 
{
	public int id;
	@NotNull(message = "Cannot be null or empty")
	@NotEmpty(message = "Cannot be null or empty")
	public String firstname;
	@NotNull(message = "Cannot be null or empty")
	@NotEmpty(message = "Cannot be null or empty")
	public String lastname;
	@NotNull(message = "Cannot be null or empty")
	@NotEmpty(message = "Cannot be null or empty")
	@Length(min=10,max=10)
	public String mobile;
	public String phone;
	@Length(min=9,max=9)
	public String afm;
	public String doy;
	public String adt; 
	public String address;
	@Length(min=5,max=5)
	public String tk;
	public String city;
	@Email
	public String email;
	public String type;
}

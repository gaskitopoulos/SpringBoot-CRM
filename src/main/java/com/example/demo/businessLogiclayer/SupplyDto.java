package com.example.demo.businessLogiclayer;

import org.hibernate.validator.constraints.Length;

public class SupplyDto 
{
	public int id;
	public ContactDto contact;
	public String status;
	public String address;
	@Length(min=5,max=5)
	public String tk;
	public String city;
	public String ship_address;
	@Length(min=5,max=5)
	public String ship_tk;
	public String ship_city;
	public String typos_syndesis;
	public String supply_no;
	public String kva;
	public String programma;
	public String ebill;
	public String pagia;
	public String energy;
	public String create_date;
	public String send_date;
	public UserDto agent;
	public String comments;
	public String pending_comments;
}

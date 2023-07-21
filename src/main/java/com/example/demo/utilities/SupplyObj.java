package com.example.demo.utilities;


import com.example.demo.businessLogiclayer.ContactDto;
import com.example.demo.businessLogiclayer.SupplyDto;
import com.example.demo.businessLogiclayer.UserDto;

public class SupplyObj 
{	
	public int id;
	public String address;
	public String tk;
	public String city;
	public String ship_address;
	public String ship_city;
	public String ship_tk;
	public String status;
	public String typos_syndesis;
	public String supply_no;
	public String kva;
	public String programma;
	public String ebill;
	public String pagia;
	public String energy;
	public String create_date;
	public String send_date;
	public String comments;
	public String pending_comments;
	public String contactAFM;
	public String agentName;
	
	public SupplyDto toDto(SupplyObj o,ContactDto contactDto,UserDto userDto) throws Exception
	{
		return new SupplyDto()
				{{
					id = o.id;
					address = o.address;
					tk = o.tk;
					city = o.city;
					ship_address = o.ship_address;
					ship_city = o.ship_city;
					ship_tk = o.ship_tk;
					status = o.status;
					typos_syndesis = o.typos_syndesis;
					supply_no = o.supply_no;
					kva = o.kva;
					programma = o.programma;
					ebill = o.ebill;
					pagia = o.pagia;
					energy = o.energy;
					create_date = o.create_date;
					send_date = o.send_date;
					comments = o.comments;
					pending_comments = o.pending_comments;
					contact = contactDto;
					agent = userDto;
				}};
	}
}

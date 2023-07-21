package com.example.demo.businessLogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domainlayer.Contact;
import com.example.demo.domainlayer.Supply;
import com.example.demo.domainlayer.SupplyRepository;
import com.example.demo.domainlayer.User;
import com.example.demo.utilities.SearchCriteria;

@Service
public class SupplyService 
{
	@Autowired
	SupplyRepository sr;
	
	public List<SupplyDto> getSupplies()
	{
		List<Supply> list = sr.getSupplies();
		return list.stream().map(s -> new SupplyDto()
				{{
					id = s.id;
					status = s.status;
					contact = new ContactDto() 
					{{
						id = s.contact.id;
						firstname = s.contact.firstname;
						lastname = s.contact.lastname;
						mobile = s.contact.mobile;
						phone = s.contact.phone;
						afm = s.contact.afm;
						adt = s.contact.adt;
						doy = s.contact.doy;
						email = s.contact.email;
						type = s.contact.type;
						address = s.contact.address;
						tk = s.contact.tk;
						city = s.contact.city;
					}};
					address = s.address;
					tk = s.tk;
					city = s.city;
					ship_address = s.ship_address;
					ship_tk = s.ship_tk;
					ship_city = s.ship_city;
					typos_syndesis = s.typos_syndesis;
					supply_no = s.supply_no;
					kva = s.kva;
					energy = s.energy;
					ebill = s.ebill;
					pagia = s.pagia;
					programma = s.programma;
					create_date = s.create_date;
					send_date = s.send_date;
					comments = s.comments;
					pending_comments = s.pending_comments;
					agent = new UserDto()
					{{
						id = s.agent.id;
						name = s.agent.name;
						category = s.agent.category;
						username = s.agent.username;
						password = s.agent.password;
					}};
				}}).collect(Collectors.toList());
	}
	
	public SupplyDto getSupplyById(int id)
	{
		Supply s= sr.getSupplyById(id);
		return new SupplyDto()
				{{
					{{
						id = s.id;
						contact = new ContactDto() 
						{{
							id = s.contact.id;
							firstname = s.contact.firstname;
							lastname = s.contact.lastname;
							mobile = s.contact.mobile;
							phone = s.contact.phone;
							afm = s.contact.afm;
							adt = s.contact.adt;
							doy = s.contact.doy;
							email = s.contact.email;
							type = s.contact.type;
							address = s.contact.address;
							tk = s.contact.tk;
							city = s.contact.city;
						}};
						status = s.status;
						address = s.address;
						tk = s.tk;
						city = s.city;
						ship_address = s.ship_address;
						ship_tk = s.ship_tk;
						ship_city = s.ship_city;
						typos_syndesis = s.typos_syndesis;
						supply_no = s.supply_no;
						kva = s.kva;
						energy = s.energy;
						ebill = s.ebill;
						pagia = s.pagia;
						programma = s.programma;
						create_date = s.create_date;
						send_date = s.send_date;
						comments = s.comments;
						pending_comments = s.pending_comments;
						agent = new UserDto()
						{{
							id = s.agent.id;
							name = s.agent.name;
							category = s.agent.category;
							username = s.agent.username;
							password = s.agent.password;
						}};
					}}
				}};
	}
	
	public void createSupply(SupplyDto dto)
	{
		Supply s = new Supply()
				{{
					contact = new Contact()
							{{
								id = dto.contact.id;
								firstname = dto.contact.firstname;
								lastname = dto.contact.lastname;
								phone = dto.contact.phone;
								mobile = dto.contact.mobile;
								afm = dto.contact.afm;
								adt = dto.contact.adt;
								doy = dto.contact.doy;
								email = dto.contact.email;
								address = dto.contact.address;
								tk = dto.contact.tk;
								city = dto.contact.city;
							}};
					status = dto.status;
					address = dto.address;
					tk = dto.tk;
					city = dto.city;
					ship_address = dto.ship_address;
					ship_tk = dto.ship_tk;
					ship_city = dto.ship_city;
					typos_syndesis = dto.typos_syndesis;
					supply_no = dto.supply_no;
					kva = dto.kva;
					programma = dto.programma;
					pagia = dto.pagia;
					ebill = dto.ebill;
					energy = dto.energy;
					create_date = dto.create_date;
					send_date = dto.send_date;
					comments = dto.comments;
					pending_comments = dto.pending_comments;
					agent = new User()
							{{
								id = dto.agent.id;
								name = dto.agent.name;
								category = dto.agent.category;
								username = dto.agent.username;
								password = dto.agent.password;
							}};
				}};
		sr.createSupply(s);
	}
	
	public SupplyDto updateSupply(SupplyDto dto)
	{
		Supply s = new Supply()
		{{
			id = dto.id;
			contact = new Contact()
					{{
						id = dto.contact.id;
						firstname = dto.contact.firstname;
						lastname = dto.contact.lastname;
						phone = dto.contact.phone;
						mobile = dto.contact.mobile;
						afm = dto.contact.afm;
						adt = dto.contact.adt;
						doy = dto.contact.doy;
						email = dto.contact.email;
						address = dto.contact.address;
						tk = dto.contact.tk;
						city = dto.contact.city;
					}};
			status = dto.status;
			address = dto.address;
			tk = dto.tk;
			city = dto.city;
			ship_address = dto.ship_address;
			ship_tk = dto.ship_tk;
			ship_city = dto.ship_city;
			typos_syndesis = dto.typos_syndesis;
			supply_no = dto.supply_no;
			kva = dto.kva;
			programma = dto.programma;
			pagia = dto.pagia;
			ebill = dto.ebill;
			energy = dto.energy;
			create_date = dto.create_date;
			send_date = dto.send_date;
			comments = dto.comments;
			pending_comments = dto.pending_comments;
			agent = new User()
					{{
						id = dto.agent.id;
						name = dto.agent.name;
						category = dto.agent.category;
						username = dto.agent.username;
						password = dto.agent.password;
					}};
		}};
		sr.updateSupply(s);
		return dto;
	}
	
	public List<SupplyDto> getSuppliesByCriteria(SearchCriteria criteria)
	{
		List<Supply> list = sr.getSuppliesByCriteria(criteria);
		return list.stream().map(s -> new SupplyDto()
		{{
			id = s.id;
			status = s.status;
			contact = new ContactDto() 
			{{
				id = s.contact.id;
				firstname = s.contact.firstname;
				lastname = s.contact.lastname;
				mobile = s.contact.mobile;
				phone = s.contact.phone;
				afm = s.contact.afm;
				adt = s.contact.adt;
				doy = s.contact.doy;
				email = s.contact.email;
				type = s.contact.type;
				address = s.contact.address;
				tk = s.contact.tk;
				city = s.contact.city;
			}};
			address = s.address;
			tk = s.tk;
			city = s.city;
			ship_address = s.ship_address;
			ship_tk = s.ship_tk;
			ship_city = s.ship_city;
			typos_syndesis = s.typos_syndesis;
			supply_no = s.supply_no;
			kva = s.kva;
			energy = s.energy;
			ebill = s.ebill;
			pagia = s.pagia;
			programma = s.programma;
			create_date = s.create_date;
			send_date = s.send_date;
			comments = s.comments;
			pending_comments = s.pending_comments;
			agent = new UserDto()
			{{
				id = s.agent.id;
				name = s.agent.name;
				category = s.agent.category;
				username = s.agent.username;
				password = s.agent.password;
			}};
		}}).collect(Collectors.toList());
	}
}





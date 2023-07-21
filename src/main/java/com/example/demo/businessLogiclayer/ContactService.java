package com.example.demo.businessLogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domainlayer.Contact;
import com.example.demo.domainlayer.ContactRepository;


import jakarta.validation.Validator;

@Service
public class ContactService 
{
	@Autowired
	ContactRepository cr;
	
	@Autowired
	Validator validator;
	
	public List<ContactDto> getContacts()
	{
		return cr
				.getContact()
				.stream()
				.map(c -> new ContactDto()
						{{
							id = c.id;
							firstname = c.firstname;
							lastname = c.lastname;
							mobile = c.mobile;
							phone = c.phone;
							afm = c.afm;
							adt = c.adt;
							doy = c.doy;
							address = c.address;
							email = c.email;
							tk = c.tk;
							city = c.city;
							type = c.type;
						}})
				.collect(Collectors.toList());
	}
	
	public ContactDto getById(int id) throws Exception
	{
		Contact c = cr.getById(id);
		return new ContactDto()
				{{
					id = c.id;
					firstname = c.firstname;
					lastname = c.lastname;
					mobile = c.mobile;
					phone = c.phone;
					afm = c.afm;
					adt = c.adt;
					doy = c.doy;
					address = c.address;
					email = c.email;
					tk = c.tk;
					city = c.city;
					type = c.type;
				}};
	}
	
	public ContactDto getByAFM(String afm) throws Exception
	{
		Contact c = cr.getByAFM(afm);
		if(c==null) throw new Exception();
		return new ContactDto()
		{{
			id = c.id;
			firstname = c.firstname;
			lastname = c.lastname;
			mobile = c.mobile;
			phone = c.phone;
			afm = c.afm;
			adt = c.adt;
			doy = c.doy;
			address = c.address;
			email = c.email;
			tk = c.tk;
			city = c.city;
			type = c.type;
		}};
	}
	
	public int createContact(ContactDto c) throws Exception
	{
		List<String> validationViolationMessages = validator.validate(c).stream().map(v -> v.getMessage()).collect(Collectors.toList());
		if (validationViolationMessages.size() > 0)
			throw new Exception(String.join("\n", validationViolationMessages));

		int id = this.cr.createContact(new Contact() {{
			firstname = c.firstname;
			lastname = c.lastname;
			mobile = c.mobile;
			phone = c.phone;
			adt = c.adt;
			doy = c.doy;
			afm = c.afm;
			address = c.address;
			tk = c.tk;
			email = c.email;
			city = c.city;
			type = c.type;
		}});
		return id;
	}
	
	public ContactDto updateContact(ContactDto dto) throws Exception
	{
		List<String> validationViolationMessages = validator.validate(dto).stream().map(v -> v.getMessage()).collect(Collectors.toList());
		if (validationViolationMessages.size() > 0)
			throw new Exception(String.join("\n", validationViolationMessages));
		
		Contact contact = new Contact()
				{{
					id = dto.id;
					firstname = dto.firstname;
					lastname = dto.lastname;
					mobile = dto.mobile;
					phone = dto.phone;
					adt = dto.adt;
					afm = dto.afm;
					doy = dto.doy;
					email = dto.email;
					address = dto.address;
					tk = dto.tk;
					city = dto.city;
					type = dto.type;
				}};
		cr.updateContact(contact);
		return dto;
	}
	
	
}

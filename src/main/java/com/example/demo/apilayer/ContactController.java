package com.example.demo.apilayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogiclayer.ContactDto;
import com.example.demo.businessLogiclayer.ContactService;


@RestController
@RequestMapping("/contacts")
public class ContactController 
{
	@Autowired
	ContactService contactsrv;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseContainer<?>> getContacts()
	{
		try 
		{
			List<ContactDto> response = contactsrv.getContacts();
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = response;}},HttpStatus.OK);
		}
		catch (Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.getStackTrace().toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{afm}")
	public ResponseEntity<ResponseContainer<?>> getByAfm(@PathVariable String afm)
	{
		try
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = contactsrv.getByAFM(afm);}},HttpStatus.OK);
		}
		catch(Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = "Δεν βρέθηκε επαφή με αυτό το ΑΦΜ";}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<ResponseContainer<?>> createContact(@RequestBody ContactDto dto)
	{
		try
        {
			int id = contactsrv.createContact(dto);
	        return new ResponseEntity<>(
	        		new ResponseContainer<Object>() {{ data = id; }}, 
	        		HttpStatus.CREATED);
        }
        catch (Exception x)
        {
        	return new ResponseEntity<>(
        			new ResponseContainer<Object>() {{ data = null; message = x.getMessage(); }},
        			HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseContainer<?>> updateContact(@RequestBody ContactDto dto)
	{
		try
		{
			ContactDto response = contactsrv.updateContact(dto);
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = response;}},HttpStatus.CREATED);
		}
		catch(Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.getStackTrace().toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
	
}

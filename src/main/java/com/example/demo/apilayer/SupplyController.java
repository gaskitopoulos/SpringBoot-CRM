package com.example.demo.apilayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogiclayer.ContactDto;
import com.example.demo.businessLogiclayer.ContactService;
import com.example.demo.businessLogiclayer.SupplyDto;
import com.example.demo.businessLogiclayer.SupplyService;
import com.example.demo.businessLogiclayer.UserDto;
import com.example.demo.businessLogiclayer.UserService;
import com.example.demo.utilities.SearchCriteria;
import com.example.demo.utilities.SupplyObj;


@RestController
@RequestMapping("/supplies")
public class SupplyController 
{
	@Autowired
	SupplyService ss;
	
	@Autowired
	ContactService cs;
	
	@Autowired
	UserService us;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseContainer<?>> get()
	{
		try
		{
			List<SupplyDto> list = ss.getSupplies();
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = list;}},HttpStatus.OK);
		}
		catch (Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ResponseContainer<?>> getSupplyById(@PathVariable("id") Integer id)
	{
		try
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = ss.getSupplyById(id); }},HttpStatus.OK);
		}
		catch (Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseContainer<?>> createSupply(@RequestBody SupplyObj sup)
	{
		try
		{
			ContactDto c = cs.getByAFM(sup.contactAFM);
			UserDto u = us.getByName(sup.agentName);
			SupplyDto dto = sup.toDto(sup,c,u);
			ss.createSupply(dto);
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = "Created!";}},HttpStatus.CREATED);
		}
		catch (Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseContainer<?>> updateSupply(@RequestBody SupplyObj sup)
	{
		try
		{
			ContactDto c = cs.getByAFM(sup.contactAFM);
			UserDto u = us.getByName(sup.agentName);
			SupplyDto dto = sup.toDto(sup,c,u);
			ss.updateSupply(dto);
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = "Updated!";}},HttpStatus.OK);
		}
		catch (Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/search")
	public ResponseEntity<ResponseContainer<?>> search(@RequestBody SearchCriteria criteria)
	{
		try 
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = ss.getSuppliesByCriteria(criteria);}},HttpStatus.OK);
		}
		catch (Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{message = x.toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
}

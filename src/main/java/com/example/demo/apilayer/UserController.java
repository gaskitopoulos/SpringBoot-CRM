package com.example.demo.apilayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogiclayer.UserDto;
import com.example.demo.businessLogiclayer.UserService;


@RestController
@RequestMapping("/users")
public class UserController 
{
	@Autowired
	UserService us;
	
	@GetMapping("/get")
	public ResponseEntity<ResponseContainer<?>> getUsers()
	{
		try
		{
			List<UserDto> response = us.getUsers();
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = response;}},HttpStatus.OK);
					
		}
		catch(Exception x)
		{
			return new ResponseEntity<>(
					new ResponseContainer<Object>() {{data = null; message = x.getStackTrace().toString();}},HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	
}

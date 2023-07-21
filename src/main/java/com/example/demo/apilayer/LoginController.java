package com.example.demo.apilayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.businessLogiclayer.UserDto;
import com.example.demo.businessLogiclayer.UserService;
import com.example.demo.utilities.LoginCredentials;



@RestController
@RequestMapping("/login")
public class LoginController 
{
	@Autowired
	UserService us;
	
	@CrossOrigin
	@PostMapping("/")
	public ResponseEntity<ResponseContainer<?>> login(@RequestBody LoginCredentials lc)
	{
		try
        {
			UserDto u = us.loginget(lc);
	        return new ResponseEntity<>(
	        		new ResponseContainer<Object>() {{ data = u; }}, 
	        		HttpStatus.CREATED);
        }
        catch (Exception x)
        {
        	return new ResponseEntity<>(
        			new ResponseContainer<Object>() {{ data = null; message = "Λάθος στοιχεία εισόδου."; }},
        			HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}
	
	
	
	
	
}

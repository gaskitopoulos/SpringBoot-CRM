package com.example.demo.businessLogiclayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domainlayer.User;
import com.example.demo.domainlayer.UserRepository;
import com.example.demo.utilities.LoginCredentials;

@Service
public class UserService 
{
	@Autowired
	UserRepository ur;
	
	public List<UserDto> getUsers()
	{
		List<User> list = ur.getUsers();
		List<UserDto> dtolist = list.stream()
				.map(o -> new UserDto() 
				{{
					id = o.id;
					name = o.name;
					category = o.category;
					username = o.username;
					password = o.password;
				}}).collect(Collectors.toList());
		return dtolist;
	}
	
	public UserDto getById(int id)
	{
		User o = ur.getUserById(id);
		return new UserDto()
				{{
					id = o.id;
					name = o.name;
					category = o.category;
					username = o.username;
					password = o.password;
				}};
	}
	
	public UserDto getByName(String name) throws Exception
	{
		User o = ur.getByName(name);
		return new UserDto()
		{{
			id = o.id;
			name = o.name;
			category = o.category;
			username = o.username;
			password = o.password;
		}};
	}
	
	public UserDto loginget(LoginCredentials lc) throws Exception
	{
		User u = ur.loginget(lc);
		if (u==null)
		{
			throw new Exception();
		}
		return new UserDto()
				{{
					id = u.id;
					name = u.name;
					username = u.username;
					password = u.password;
					category = u.category;
				}};
	}
	
	
	
}

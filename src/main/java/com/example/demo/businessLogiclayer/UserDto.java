package com.example.demo.businessLogiclayer;

import jakarta.validation.constraints.*;

public class UserDto 
{
	public int id;
	@NotNull(message="Name cannot be null or empty")
	@NotEmpty(message="Name cannot be null or empty")
	public String name;
	@NotNull(message="Category cannot be null or empty")
	@NotEmpty(message="Category cannot be null or empty")
	public String category;
	@NotNull(message="Username cannot be null or empty")
	@NotEmpty(message="Username cannot be null or empty")
	public String username;
	@NotNull(message="Password cannot be null or empty")
	@NotEmpty(message="Password cannot be null or empty")
	public String password;
}

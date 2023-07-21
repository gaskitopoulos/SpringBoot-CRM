package com.example.demo.domainlayer;

import jakarta.persistence.*;

@Entity(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	public String name;
	public String category;
	@Column(unique=true)
	public String username;
	public String password;
}

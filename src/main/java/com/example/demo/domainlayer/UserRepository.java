package com.example.demo.domainlayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.utilities.LoginCredentials;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class UserRepository 
{
	@PersistenceContext
	EntityManager em;
	
	public List<User> getUsers()
	{
		return em.createQuery("Select u from users u",User.class).getResultStream().filter(u -> u instanceof User)
				.map(u -> (User)u).collect(Collectors.toList());
	}
	
	public User getUserById(int id)
	{
		return em.find(User.class, id);
	}
	
	public User getByName(String name)
	{
		return em.createQuery("select u from users u where u.name = ?1",User.class).setParameter(1, name).getSingleResult();
	}
	
	public User loginget(LoginCredentials lc)
	{
		User u= em.createQuery("select u from users u where u.username= ?1 and u.password = ?2", User.class)
				.setParameter(1, lc.username).setParameter(2, lc.password).getSingleResult();
		try
		{
			return u;
		}
		catch (Exception x)
		{
			return null;
		}
	}
}

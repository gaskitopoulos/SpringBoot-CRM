package com.example.demo.domainlayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class ContactRepository 
{
	
	@PersistenceContext
	EntityManager em;
	
	public List<Contact> getContact()
	{
		List<Contact> result = em
				.createQuery("Select c from contacts c", Contact.class)
				.getResultStream().filter(o -> o instanceof Contact)
				.map(o -> (Contact)o).collect(Collectors.toList());
		return result;
	}
	
	public Contact getById(int id)
	{
		return em.find(Contact.class, id);
	}
	
	public Contact getByAFM(String afm)
	{
		Contact c = em.createQuery("select c from contacts c where c.afm = ?1",Contact.class).setParameter(1, afm).getSingleResult();
		return c;
	}
	
	public int createContact(Contact contact)
	{
		em.createNativeQuery("INSERT INTO contacts (firstname,lastname,mobile,phone,afm,doy,adt,address,tk,city,email,type) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)")
		.setParameter(1, contact.firstname).setParameter(2, contact.lastname)
		.setParameter(3, contact.mobile).setParameter(4, contact.phone)
		.setParameter(5, contact.afm).setParameter(6, contact.doy)
		.setParameter(7, contact.adt).setParameter(8, contact.address)
		.setParameter(9, contact.tk).setParameter(10, contact.city)
		.setParameter(11, contact.email).setParameter(12, contact.type)
		.executeUpdate();
		
		int entityId = ((Number) em
				.createNativeQuery("SELECT c.id FROM contacts c WHERE c.afm = ?")
				.setParameter(1, contact.afm)
				.getSingleResult()).intValue();
		return entityId;
	}
	
	public Contact updateContact(Contact c)
	{
		Contact update = this.getById(c.id);
		update.firstname = c.firstname;
		update.lastname = c.lastname;
		update.mobile = c.mobile;
		update.phone = c.phone;
		update.adt = c.adt;
		update.afm = c.afm;
		update.doy = c.doy;
		update.email = c.email;
		update.address = c.address;
		update.tk = c.tk;
		update.city = c.city;
		update.type = c.type;
		em.flush();
		
		return update;
	}
}







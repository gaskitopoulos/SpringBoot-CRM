package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domainlayer.Contact;
import com.example.demo.domainlayer.ContactRepository;

public class DomainLayerTests 
{
	@Autowired
	ContactRepository cr;
	
	@Test
	public void testCreateContact()
	{
		Contact c = new Contact()
				{{
					firstname = "Nick";
					lastname = "Aski";
					mobile = "6902147856";
					phone = "2104569871";
					adt = "XX 123654";
					doy = "ΕΔΕΣΣΑΣ";
					afm = "987546320";
					email = "nik@nik.gr";
					address = "ΒΑΛΤΕΤΣΙΟΥ 50";
					tk = "38222";
					city = "ΒΟΛΟΣ";
					type = "ΙΔΙΩΤΗΣ";
				}};
		Assertions.assertThat(cr.createContact(c)).isGreaterThan(0);
	}
}

package com.example.demo.domainlayer;

import jakarta.persistence.*;

@Entity(name = "supplies")
public class Supply 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@ManyToOne
	@JoinColumn(name="contact_id")
	public Contact contact;
	
	@Column(name = "status_current")
	public String status;
	
	public String address;
	public String tk;
	public String city;
	public String ship_address;
	public String ship_tk;
	public String ship_city;
	public String typos_syndesis;
	public String supply_no;
	public String kva;
	public String programma;
	public String pagia;
	public String ebill;
	public String energy;
	public String create_date;
	public String send_date;
	@ManyToOne
	@JoinColumn(name = "agent")
	public User agent;
	public String comments;
	public String pending_comments;
	
}

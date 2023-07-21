package com.example.demo.domainlayer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.utilities.SearchCriteria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class SupplyRepository 
{
	@PersistenceContext
	EntityManager em;
	
	public List<Supply> getSupplies()
	{
		return em.createQuery("Select s from supplies s",Supply.class).getResultStream().filter(s -> s instanceof Supply)
				.map(s -> (Supply)s).collect(Collectors.toList());
	}
	
	public Supply getSupplyById(int id)
	{
		return em.find(Supply.class, id);
	}
	
	public void createSupply(Supply s)
	{
		em.createNativeQuery("insert into supplies (contact_id,status_current,address,tk,city,ship_address,ship_tk,ship_city,"
				+ "typos_syndesis,supply_no,kva,programma,energy,ebill,pagia,create_date,send_date,agent,comments,pending_comments) "
				+ "values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14,?15,?16,?17,?18,?19,?20)")
		.setParameter(1, s.contact.id).setParameter(2, s.status).setParameter(3, s.address).setParameter(4, s.tk)
		.setParameter(5, s.city).setParameter(6, s.ship_address).setParameter(7, s.ship_tk).setParameter(8, s.ship_city)
		.setParameter(9, s.typos_syndesis).setParameter(10, s.supply_no).setParameter(11, s.kva).setParameter(12, s.programma)
		.setParameter(13, s.energy).setParameter(14, s.ebill).setParameter(15, s.pagia).setParameter(16, s.create_date)
		.setParameter(17, s.send_date).setParameter(18, s.agent.id).setParameter(19, s.comments).setParameter(20, s.pending_comments)
		.executeUpdate();
		
	}
	
	public Supply updateSupply(Supply old)
	{
		Supply update = this.getSupplyById(old.id);
		update.address = old.address;
		update.tk = old.tk;
		update.city = old.city;
		update.ship_address = old.ship_address;
		update.ship_tk = old.ship_tk;
		update.ship_city = old.ship_city;
		update.status = old.status;
		update.kva = old.kva;
		update.supply_no = old.supply_no;
		update.typos_syndesis = old.typos_syndesis;
		update.programma = old.programma;
		update.ebill = old.ebill;
		update.pagia = old.pagia;
		update.energy = old.energy;
		update.create_date = old.create_date;
		update.send_date = old.send_date;
		update.comments = old.comments;
		update.pending_comments = old.pending_comments;
		update.contact = old.contact;
		update.agent = old.agent;
		em.flush();
		
		return update;
	}
	
	public List<Supply> getSuppliesByCriteria(SearchCriteria criteria)
	{
		List<Supply> list= em.createQuery("Select s from supplies s",Supply.class).getResultStream().filter(s -> s instanceof Supply)
				.map(s -> (Supply)s).collect(Collectors.toList());
		if(!criteria.status.equals(""))
		{
			list = list.stream().filter(s -> s.status.equals(criteria.status)).collect(Collectors.toList());
		}
		if(!criteria.agentName.equals(""))
		{
			list = list.stream().filter(s -> s.agent.name.equals(criteria.agentName)).collect(Collectors.toList());
		}
		if(criteria.create.size()>0)
		{
			list = list.stream().filter(s -> criteria.create.contains(s.create_date)).collect(Collectors.toList());
		}
		if(criteria.send.size()>0)
		{
			list = list.stream().filter(s -> criteria.send.contains(s.send_date)).collect(Collectors.toList());
		}
		return list;
	}

	
	
}

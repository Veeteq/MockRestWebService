package com.mock.ws.rest.bso.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.repository.IBsoRepository;

@Repository
@Transactional
public class AgentRepository implements IBsoRepository{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	public Agent getByLnrAndSkk(long lnr, long skk) {
		System.out.println("lnr: " + lnr + ", skk: " + skk);
		Agent agent = new Agent();
		agent.setLnr(lnr);
		agent.setSkk(skk);
		save(agent);
		return agent;
		/*
		System.out.println("lnr: " + lnr + ", skk: " + skk);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query<Agent> query = session.createQuery("from Agent a WHERE a.lnr=:lnr and a.skk=:skk", Agent.class);
		query.setParameter("lnr", lnr);
		query.setParameter("skk", skk);
		List<Agent> agents = query.list();
		if(agents.size() == 0) {
			Agent agent = new Agent();
			agent.setLnr(lnr);
			agent.setSkk(skk);
			agents.add(save(agent));
		}
		return agents.get(0);		
		*/
	}
	
	public Long save(Agent agent) {
		System.out.println("trying to save agent");
		return (Long) hibernateTemplate.save(agent);
	}
}

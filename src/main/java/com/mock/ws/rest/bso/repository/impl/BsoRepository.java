package com.mock.ws.rest.bso.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.repository.IBsoRepository;

@Repository
@Transactional
public class BsoRepository implements IBsoRepository {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public Bso getBySeriesAndNumberAndType(String series, String number, String type) {
		System.out.println("series: " + series + ", number: " + number + ", type: " + type);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query<Bso> query = session.createQuery("from Bso a WHERE a.series=:series and a.number=:number and a.type=:type", Bso.class);
		query.setParameter("series", series);
		query.setParameter("number", Integer.parseInt(number));
		query.setParameter("type", Integer.parseInt(type));
		List<Bso> bsos = query.list();
		session.close();
		
		if(bsos.size() == 0) {
			return null;
		}
		
		return bsos.get(0);
	}

	public Bso save(BsoDTO bsoDTO) {
		Bso bso = new Bso();
		bso.setSeries(bsoDTO.getSeries());
		bso.setNumber(Integer.parseInt(bsoDTO.getNumber()));
		bso.setType(Integer.parseInt(bsoDTO.getType()));
		Long bsoId = save(bso);
		System.out.println("Bso saved with id: " + bsoId);
		
		return hibernateTemplate.get(Bso.class, bsoId);
	}

	private Long save(Bso bso) {
		System.out.println("trying to save bso");
		return (Long) hibernateTemplate.save(bso);
	}
}

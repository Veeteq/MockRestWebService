package com.mock.ws.rest.bso.repository.impl;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.repository.IBsoRepository;

@Repository
@Transactional
public class BsoRepository implements IBsoRepository {

	  @PersistenceContext
	  private EntityManager em;

	public Optional<Bso> getBySeriesAndNumberAndType(String series, String number, String type) {
		System.out.println("series: " + series + ", number: " + number + ", type: " + type);
		//Session session = em.createQuery(qlString, resultClass)  hibernateTemplate.getSessionFactory().openSession();
		TypedQuery<Bso> query = em.createQuery("SELECT b FROM Bso b WHERE b.series=:series and a.number=:number and a.type=:type", Bso.class);
		query.setParameter("series", series);
		query.setParameter("number", Integer.parseInt(number));
		query.setParameter("type", Integer.parseInt(type));
		Bso bso = query.getSingleResult();

		return Optional.ofNullable(bso);
	}

	public Optional<Bso> save(BsoDTO bsoDTO) {
		Bso bso = new Bso();
		bso.setSeries(bsoDTO.getSeries());
		bso.setNumber(bsoDTO.getNumber());
		bso.setType(bsoDTO.getType());
		Long bsoId = save(bso).get().getId();
		System.out.println("Bso saved with id: " + bsoId);
		
		em.persist(bso);
		return Optional.ofNullable(bso);
	}

	public Optional<Bso> save(Bso bso) {
		System.out.println("trying to save bso");
		em.persist(bso);
		return Optional.ofNullable(bso);
	}
}

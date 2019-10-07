package com.mock.ws.rest.bso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.ws.rest.bso.model.Bso;

public interface BsoRepository extends JpaRepository<Bso, Long>{

	Optional<Bso> findById(Long id);
	
	List<Bso> findBySeriesAndNumberAndType(String series, String number, String type);
}

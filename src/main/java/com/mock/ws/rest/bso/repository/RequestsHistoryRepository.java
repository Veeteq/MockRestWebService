package com.mock.ws.rest.bso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.ws.rest.bso.model.RequestsHistory;

public interface RequestsHistoryRepository extends JpaRepository<RequestsHistory, Long>{

}

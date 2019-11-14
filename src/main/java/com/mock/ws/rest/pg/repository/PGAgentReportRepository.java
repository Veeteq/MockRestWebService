package com.mock.ws.rest.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.ws.rest.bso.model.PGAgentReport;

public interface PGAgentReportRepository extends JpaRepository<PGAgentReport, Long>{
    
    PGAgentReport findByReportNumber(String reportNumber);

}

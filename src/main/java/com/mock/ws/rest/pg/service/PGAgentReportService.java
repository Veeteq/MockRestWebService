package com.mock.ws.rest.pg.service;

import java.util.List;

import com.mock.ws.rest.bso.model.PGAgentReport;

public interface PGAgentReportService {

    List<PGAgentReport> findAll();

    PGAgentReport save(PGAgentReport agentReport);
    
    PGAgentReport findByReportNumber(String reportNumber);
    
}

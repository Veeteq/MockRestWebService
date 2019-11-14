package com.mock.ws.rest.pg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.model.PGAgentReport;
import com.mock.ws.rest.pg.repository.PGAgentReportRepository;
import com.mock.ws.rest.pg.service.PGAgentReportService;

@Service
public class PGAgentReportServiceImpl implements PGAgentReportService {

    private PGAgentReportRepository agentReportRepository;

    @Autowired
    public PGAgentReportServiceImpl(PGAgentReportRepository agentReportRepository) {
        this.agentReportRepository = agentReportRepository;
    }


    @Override
    public List<PGAgentReport> findAll() {
        return agentReportRepository.findAll();
    }


    @Override
    public PGAgentReport save(PGAgentReport agentReport) {
        return agentReportRepository.save(agentReport);
    }


    @Override
    public PGAgentReport findByReportNumber(String reportNumber) {
        return agentReportRepository.findByReportNumber(reportNumber);
    }
}

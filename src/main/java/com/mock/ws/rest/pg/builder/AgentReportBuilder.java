package com.mock.ws.rest.pg.builder;

import com.mock.ws.rest.bso.model.PGAgentReport;
import com.mock.ws.rest.pg.dto.request.PGAgentReportDTO;
import com.mock.ws.rest.utils.DateUtils;

public class AgentReportBuilder {

    public static PGAgentReport buildAgentReport(PGAgentReportDTO agentReportDTO) {
        PGAgentReport agentReport = new PGAgentReport();
        agentReport.setReportDate(DateUtils.parse(agentReportDTO.getDate()));
        agentReport.setReportNumber(agentReportDTO.getNumber());
        return agentReport;
    }

}

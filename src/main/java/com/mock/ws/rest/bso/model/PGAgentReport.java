package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AGENT_REPORTS")
@AttributeOverride(name="id", column=@Column(name="AGENT_REPORT_ID"))
@SequenceGenerator(name="default_seq", sequenceName="AGENT_REPORT_SEQ", allocationSize=1)
public class PGAgentReport extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="REPORT_DATE", columnDefinition="TIMESTAMP", nullable=false)
    private LocalDateTime reportDate;
    
    @Column(name="REPORT_NUMBER")
    private String reportNumber;

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }
}

package com.mock.ws.rest.bso.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EXPECTED_PAYMENTS")
@AttributeOverride(name="id", column=@Column(name="EXPECTED_PAYMENT_ID"))
@SequenceGenerator(name="default_seq", sequenceName="EXPECTED_PAYMENT_SEQ", allocationSize=1)
public class PGExpectedPayment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="PAYMENT_NUMBER")
    private String paymentNumber;
    
    @Column(name="AMOUNT")
    private BigDecimal amount;
    
    @Column(name="KIND")
    private String kind;
    
    @Column(name="OPER_NAME")
    private String operName;
    
    @Column(name="OPER_TYPE")
    private String operType;
    
    @Column(name="PAY_TYPE")
    private String type;

    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="AGENT_ID", nullable=false)
    private Agent agent;
    
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CONTRACT_ID", nullable=true)
    private Contract contract;
    
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PAYER_ID", nullable=false)
    private PGPayer payer;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="AGENT_REPORT_ID", nullable=true)
    private PGAgentReport agentReport;

    @OneToMany(mappedBy="expectedPayment", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<PGPartialPayment> payments;

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public PGPayer getPayer() {
        return payer;
    }

    public void setPayer(PGPayer payer) {
        this.payer = payer;
    }

    public PGAgentReport getAgentReport() {
        return agentReport;
    }

    public void setAgentReport(PGAgentReport agentReport) {
        this.agentReport = agentReport;
    }

    public List<PGPartialPayment> getPayments() {
        return payments;
    }

    public boolean isFullyPaid() {
        BigDecimal paidSum = this.payments.stream().map(mapper -> mapper.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
        return paidSum.equals(this.amount);
    }

    public BigDecimal sumOfPartialPayments() {
        return this.payments.stream().map(mapper -> mapper.getAmount()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}

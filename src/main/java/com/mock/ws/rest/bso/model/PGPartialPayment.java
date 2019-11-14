package com.mock.ws.rest.bso.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "PARTIAL_PAYMENTS")
@AttributeOverride(name="id", column=@Column(name="PARTIAL_PAYMENT_ID"))
@SequenceGenerator(name="default_seq", sequenceName="PARTIAL_PAYMENT_SEQ", allocationSize=1)

public class PGPartialPayment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name="EXPECTED_PAYMENT_ID")
    private PGExpectedPayment expectedPayment;

    @Column(name="AMOUNT")
    private BigDecimal amount;
    
    @Column(name="PAID_DATE_TIME", columnDefinition="TIMESTAMP", nullable=false)
    @CreationTimestamp
    private LocalDateTime paidDateTime;
    
    @Column(name="SESSION_ID")
    private String sessionID;
    
    @Column(name="STATE")
    private String state;
    
    @Column(name="STATE_DESCRIPTION")
    private String stateDescription;
    
    @Column(name="RRN")
    private String rrn;

    public PGExpectedPayment getExpectedPayment() {
        return expectedPayment;
    }

    public void setExpectedPayment(PGExpectedPayment expectedPayment) {
        this.expectedPayment = expectedPayment;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaidDateTime() {
        return paidDateTime;
    }

    public void setPaidDateTime(LocalDateTime paidDateTime) {
        this.paidDateTime = paidDateTime;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}

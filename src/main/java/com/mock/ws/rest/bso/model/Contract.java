package com.mock.ws.rest.bso.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTRACTS")
@AttributeOverride(name="id", column=@Column(name="POLICY_ID"))
@SequenceGenerator(name="default_seq", sequenceName="CONTRACT_SEQ", allocationSize=1)
public class Contract extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name = "POLICY_SERIES")
    private String series;
    
    @Column(name = "POLICY_NUMBER")
    private String number;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

package com.mock.ws.rest.bso.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PAYERS")
@AttributeOverride(name="id", column=@Column(name="PAYER_ID"))
@SequenceGenerator(name="default_seq", sequenceName="PAYER_SEQ", allocationSize=1)
public class PGPayer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="EMAIL")
    private String email;
    
    @Column(name="NAME")
    private String name;
    
    @Column(name="PHONE")
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

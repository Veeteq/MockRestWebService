package com.mock.ws.rest.pg.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PGMerchantDTO {

    @JsonProperty(value = "id")
    private String id;
    
    @JsonProperty(value = "ckk")
    private String ckk;
    
    @JsonProperty(value = "inn")
    private String inn;
    
    @JsonProperty(value = "name")
    private String name;
    
    @JsonProperty(value = "password")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCkk() {
        return ckk;
    }

    public void setCkk(String ckk) {
        this.ckk = ckk;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

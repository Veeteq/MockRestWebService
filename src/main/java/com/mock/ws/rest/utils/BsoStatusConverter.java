package com.mock.ws.rest.utils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.mock.ws.rest.bso.model.BsoStatus;

@Converter
public class BsoStatusConverter implements AttributeConverter<BsoStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(BsoStatus status) {        
        return status.getCode();
    }

    @Override
    public BsoStatus convertToEntityAttribute(Integer code) {        
        return BsoStatus.getByCode(code);
    }

}

package com.mock.ws.rest.ocrm.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.ws.rest.ocrm.dto.request.OcrmRequest;
import com.mock.ws.rest.ocrm.dto.response.OcrmResponse;
import com.mock.ws.rest.ocrm.service.IOcrmService;

@RestController
@RequestMapping(path = "/ocrm")
public class OcrmController {

    private static final Logger logger = LoggerFactory.getLogger(OcrmController.class);
    
    private IOcrmService ocrmService;
    
    @Autowired    
    public OcrmController(IOcrmService ocrmService) {
        this.ocrmService = ocrmService;
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public ResponseEntity<OcrmResponse> readCampaignResults(@RequestBody OcrmRequest requestBody, HttpServletRequest request) {
        logger.info(requestBody.toString());
        
        OcrmResponse response = ocrmService.processRequest(requestBody);
        
        return new ResponseEntity<OcrmResponse>(response, HttpStatus.OK);
    }
}

package com.mock.ws.rest.bso.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.ws.rest.bso.dto.Notification;
import com.mock.ws.rest.bso.service.BsoService;

@RestController
@RequestMapping(path = "/bso")
public class BsoController {

	@Autowired
	BsoService bsoService;
	
	@RequestMapping(value = "/check", method = RequestMethod.GET)
	public String bsoCheck() {
		return "hello";
	}
	
	@RequestMapping(value = "/check", method = RequestMethod.POST)	
	public Notification bsoCheckStatus(@RequestBody Notification request) {
		Notification response = bsoService.processRequest(request);
		return response;
	}
}

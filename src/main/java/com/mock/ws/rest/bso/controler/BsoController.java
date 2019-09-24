package com.mock.ws.rest.bso.controler;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.ws.rest.bso.entities.Notification;

@RestController
@RequestMapping(path = "/bso")
public class BsoController {

	@RequestMapping(value = "/check", method = RequestMethod.POST)
	public Notification bsoCheckStatus(@RequestBody Notification request) {
		Notification response = new Notification();
		
		response.setBusinessData(request.getBusinessData());
		response.setTechData(request.getTechData());
		return response;
	}
}

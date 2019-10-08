package com.mock.ws.soap.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ISOAPService {

	@WebMethod
	String getAgentByCode(Long agentCode);

}
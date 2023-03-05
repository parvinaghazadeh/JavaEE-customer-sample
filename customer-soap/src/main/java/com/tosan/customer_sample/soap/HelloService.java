package com.tosan.customer_sample.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "HelloService", targetNamespace = "http://com.tosan.customer_sample.soap/")
public interface HelloService {

	@WebMethod(operationName = "hello")
	public String hello(String name);
	
//	@WebMethod(operationName = "sumNumbers")
//	public SumResponse sumNumbers(SumRequest sumRequest);
}
package com.tosan.customer_sample.soap;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(portName = "HelloServicePort", serviceName = "HelloServiceService",
		targetNamespace = "http://com.tosan.customer_sample.soap/",
		endpointInterface = "com.tosan.customer_sample.soap.HelloService")
//
//@HandlerChain(file = "TosanWSHandler.xml")
public class HelloServiceImpl implements HelloService {

//	@EJB
//	@Inject
//	private HelloLocal helloLocal;

	public String hello(String name) {
		return "Welcome "  /*+ helloLocal.sayHello()*/  + " " + name;

	}

//	public SumResponse sumNumbers(SumRequest sumRequest) {
//		SumResponse sumResponse = new  SumResponse();
//
//		sumResponse.setTotal(sumRequest.getNumber1() + sumRequest.getNumber2());
//		return sumResponse;
//	}
	
	
}

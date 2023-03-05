package com.tosan.customer_sample.rest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@OpenAPIDefinition(servers = {@Server(url = "/rest/api")})
public class RestApplication extends Application{
//@OpenAPIDefinition(servers = {@Server(url = "/rest/")})
//@ApplicationPath("/")
}

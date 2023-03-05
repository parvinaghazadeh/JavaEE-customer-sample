package com.tosan.customer_sample.rest.controller;

import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerCreateRequestDto;
import com.tosan.customer_sample.api.dto.customer.CustomerResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerUpdateRequestDto;
import com.tosan.customer_sample.core.service.CustomerService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/customer")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @GET
    @Path("/{id}")
    public ResponseDto<CustomerResponseDto> getCustomer(@PathParam("id")final long id) {
        return customerService.getCustomer(id);
    }

    @GET
    public List<CustomerResponseDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @POST
    @Transactional
    public Response createCustomer(final CustomerCreateRequestDto customer) {
        return Response.ok(customerService.createCustomer(customer)).build();
    }

    @PUT
    @Transactional
    public Response replaceCustomer(final CustomerUpdateRequestDto customer) {
        return Response.ok(customerService.replaceCustomer(customer)).build();
    }

    @PATCH
    public Response updateCustomer(final CustomerUpdateRequestDto customer) {
        return Response.ok(customerService.updateCustomer(customer)).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteCustomer(@PathParam("id") final long id) {
        return Response.ok(customerService.deleteCustomer(id)).build();
    }
}

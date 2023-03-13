package com.tosan.customer_sample.rest.controller;

import com.tosan.customer_sample.api.dto.account.AccountCreateRequestDto;
import com.tosan.customer_sample.api.dto.account.AccountResponseDto;
import com.tosan.customer_sample.api.dto.account.AccountUpdateRequestDto;
import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.core.exception.AccountIdNullException;
import com.tosan.customer_sample.core.service.AccountService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/account")
@Produces(MediaType.APPLICATION_JSON)
public class AccountController {

    @Inject
    private AccountService accountService;

    @GET
    @Path("/{id}")
    public ResponseDto<AccountResponseDto> getAccount(@PathParam("id") final long id) throws AccountIdNullException {
        return accountService.getAccount(id);
    }

//    @GET
//    @Path("/{customerId}")
//    public List<AccountEntity> getAccountByCustomer(@PathParam("customerId") final long customerId) {
//        List<AccountEntity> accountList = accountDao.findByCustomer(customerId);
//        return accountList;
//    }

    @GET
    public List<AccountResponseDto> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @POST
    @Transactional
    public Response createAccount(AccountCreateRequestDto accountRequest) {
        return Response.ok(accountService.createAccount(accountRequest)).build();
    }

    @PUT
    @Transactional
    public Response updateAccount(AccountUpdateRequestDto account) {
        return Response.ok(accountService.updateAccount(account)).build();
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Response deleteAccount(@PathParam("id") final long id) {
        return Response.ok(accountService.deleteAccount(id)).build();
    }

}

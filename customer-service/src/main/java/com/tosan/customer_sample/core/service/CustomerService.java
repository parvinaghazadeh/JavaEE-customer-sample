package com.tosan.customer_sample.core.service;

import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerCreateRequestDto;
import com.tosan.customer_sample.api.dto.customer.CustomerResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerUpdateRequestDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerService {

    ResponseDto<CustomerResponseDto> getCustomer(Long customerId);

    List<CustomerResponseDto> getAllCustomers();

    ResponseDto createCustomer(CustomerCreateRequestDto customerRequest);

    ResponseDto replaceCustomer(CustomerUpdateRequestDto customerRequest);

    ResponseDto updateCustomer(CustomerUpdateRequestDto customerRequest);

    ResponseDto deleteCustomer(long customerId);

}

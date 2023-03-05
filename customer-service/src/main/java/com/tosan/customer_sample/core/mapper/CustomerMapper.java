package com.tosan.customer_sample.core.mapper;

import com.tosan.customer_sample.api.dto.customer.CustomerCreateRequestDto;
import com.tosan.customer_sample.api.dto.customer.CustomerResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerUpdateRequestDto;
import com.tosan.customer_sample.api.entity.CustomerEntity;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class CustomerMapper {

    public CustomerResponseDto map(CustomerEntity customerEntity) {
        CustomerResponseDto responseDto = new CustomerResponseDto();
        responseDto.setAccountList(customerEntity.getAccountList());
        responseDto.setCustomerType(customerEntity.getCustomerType());
        responseDto.setId(customerEntity.getId());
        responseDto.setMobile(customerEntity.getMobile());
        responseDto.setPhone(customerEntity.getPhone());
        responseDto.setMobile(customerEntity.getMobile());
        responseDto.setNationalCode(customerEntity.getNationalCode());
        responseDto.setName(customerEntity.getFirstName() + " " + customerEntity.getLastName());
        return responseDto;
    }

    public List<CustomerResponseDto> map(List<CustomerEntity> customerEntityList) {
        List<CustomerResponseDto> result = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntityList) {
            result.add(map(customerEntity));
        }
        return result;
    }

    public CustomerEntity map(CustomerCreateRequestDto requestDto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(requestDto.getFirstName());
        customer.setLastName(requestDto.getLastName());
        customer.setPhone(requestDto.getPhone());
        customer.setMobile(requestDto.getMobile());
        customer.setBirthDate(requestDto.getBirthDate());
        customer.setNationalCode(requestDto.getNationalCode());
        customer.setCustomerType(requestDto.getCustomerType());
        return customer;
    }

    public CustomerEntity map(CustomerUpdateRequestDto requestDto) {
        CustomerEntity customer = new CustomerEntity();
        customer.setFirstName(requestDto.getFirstName());
        customer.setLastName(requestDto.getLastName());
        customer.setPhone(requestDto.getPhone());
        customer.setMobile(requestDto.getMobile());
        customer.setBirthDate(requestDto.getBirthDate());
        customer.setNationalCode(requestDto.getNationalCode());
        customer.setCustomerType(requestDto.getCustomerType());
        return customer;
    }

}

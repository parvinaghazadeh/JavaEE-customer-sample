package com.tosan.customer_sample.core.service.impl;

import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerCreateRequestDto;
import com.tosan.customer_sample.api.dto.customer.CustomerResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerUpdateRequestDto;
import com.tosan.customer_sample.api.entity.CustomerEntity;
import com.tosan.customer_sample.core.mapper.CustomerMapper;
import com.tosan.customer_sample.dao.CustomerDao;
import com.tosan.customer_sample.core.service.CustomerService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
import java.util.Objects;

@Stateless
@WebService(name ="CustService", portName = "CustServicePort", serviceName ="CustFacadeImpl"
        , targetNamespace ="http://www.tosan.com/cust")
public class CustomerServiceImpl implements CustomerService {

    @Inject
    private CustomerDao customerDao;

    @Inject
    private CustomerMapper customerMapper;

    @Override
    public ResponseDto<CustomerResponseDto> getCustomer(long customerId) {
        CustomerEntity customerEntity = customerDao.findById(customerId);
        ResponseDto<CustomerResponseDto> result = new ResponseDto();
        if (Objects.isNull(customerEntity)) {
            result.message("not found any item!").status("404").build();
        }
        else {
            result.message("ok").status("200").result(customerMapper.map(customerEntity)).build();
        }
        return result;
    }

    @Override
    public List<CustomerResponseDto> getAllCustomers() {
        List<CustomerEntity> customerEntityList = customerDao.findAll();
        return customerMapper.map(customerEntityList);
    }

    @Override
    public ResponseDto createCustomer(CustomerCreateRequestDto customerRequest) {
        customerDao.insert(customerMapper.map(customerRequest));
        return new ResponseDto("ok","200",null);
    }

    @Override
    public ResponseDto replaceCustomer(CustomerUpdateRequestDto customerRequest) {
        customerDao.update(customerMapper.map(customerRequest));
        return new ResponseDto("ok","200",null);
    }

    @Override
    public ResponseDto updateCustomer(CustomerUpdateRequestDto customerRequest) {
        customerDao.update(customerMapper.map(customerRequest));
        return new ResponseDto("ok","200",null);
    }

    @Override
    public ResponseDto deleteCustomer(long customerId) {
        CustomerEntity customer = null;
        customer = customerDao.findById(customerId);
        customerDao.delete(customer);
        return new ResponseDto("ok","200",null);
    }
}

package com.tosan.customer_sample.core.test.CustomerService;

import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.api.dto.customer.CustomerResponseDto;
import com.tosan.customer_sample.api.entity.CustomerEntity;
import com.tosan.customer_sample.core.mapper.CustomerMapper;
import com.tosan.customer_sample.core.service.CustomerService;
import com.tosan.customer_sample.core.service.impl.CustomerServiceImpl;
import com.tosan.customer_sample.dao.CustomerDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.HashSet;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindCustomerByIdUT {

    @Mock
    private CustomerDao customerDao;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerService customerService = new CustomerServiceImpl();

    @Test
    public void foundCustomer_SuccessScenario() {
        doAnswer(new Answer<CustomerEntity>() {
            @Override
            public CustomerEntity answer(InvocationOnMock invocationOnMock) throws Throwable {
                CustomerEntity customerEntity = new CustomerEntity();
                customerEntity.setAccountList(new HashSet<>());
                return customerEntity;
            }
        }).when(customerDao).findById(anyLong());
        ResponseDto<CustomerResponseDto> responseDto = customerService.getCustomer(11L);
        assertThat(responseDto, hasProperty("status", is("200")));
    }

    @Test
    public void notFoundCustomer_SuccessScenario() {
        when(customerDao.findById(anyLong())).thenReturn(null);
        ResponseDto<CustomerResponseDto> responseDto = customerService.getCustomer(11L);
        assertThat(responseDto, hasProperty("status", is("404")));
    }

}

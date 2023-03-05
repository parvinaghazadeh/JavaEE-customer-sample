package com.tosan.customer_sample.dao;


import com.tosan.customer_sample.api.entity.CustomerEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CustomerDao {

    void insert(CustomerEntity customer);

    void update(CustomerEntity customer);

    void delete(CustomerEntity customer);

    List<CustomerEntity> findAll();

    CustomerEntity findById(Long id);
}

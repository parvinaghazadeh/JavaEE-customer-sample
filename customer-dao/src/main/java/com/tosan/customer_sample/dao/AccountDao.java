package com.tosan.customer_sample.dao;

import com.tosan.customer_sample.api.entity.AccountEntity;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccountDao {

    void insert(AccountEntity account);

    void update(AccountEntity account);

    void delete(Long id);

    List<AccountEntity> findAll();

    AccountEntity findById(Long id);

    List<AccountEntity> findByCustomer(Long customerId);

}

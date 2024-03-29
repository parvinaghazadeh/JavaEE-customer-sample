package com.tosan.customer_sample.dao.impl;

import com.tosan.customer_sample.api.entity.AccountEntity;
import com.tosan.customer_sample.dao.AccountDao;
import com.tosan.customer_sample.dao.DaoInterceptor;

import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Interceptors(DaoInterceptor.class)
public class AccountDaoImpl implements AccountDao {

//    @PersistenceContext(unitName = "persistenceCustomerUnit")
    @PersistenceContext(unitName = "persistenceCustomerOpenJpaUnit")
    EntityManager entityManager;

    @Override
    public void insert(AccountEntity account) {
        entityManager.persist(account);
    }

    @Override
    public void update(AccountEntity account) {
        entityManager.merge(account);
    }

    @Override
    public void delete(Long id) {
        Query query = entityManager.createNamedQuery("accountDao.deleteAccount");
        query.setParameter(1, id);
        query.executeUpdate();
    }

    @Override
    public List<AccountEntity> findAll() {
        Query query = entityManager.createNamedQuery("accountDao.listAll");
        return (List<AccountEntity>) query.getResultList();
    }

    @Override
    public AccountEntity findById(Long id) {
        return entityManager.find(AccountEntity.class, id);
    }

    @Override
    public List<AccountEntity> findByCustomer(Long customerId) {
        Query query = entityManager.createNamedQuery("accountDao.getListByCustomerId");
        query.setParameter(1, customerId);
        return (List<AccountEntity>) query.getResultList();
    }
}

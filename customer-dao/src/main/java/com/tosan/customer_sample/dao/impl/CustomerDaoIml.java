package com.tosan.customer_sample.dao.impl;


import com.tosan.customer_sample.api.entity.CustomerEntity;
import com.tosan.customer_sample.dao.CustomerDao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class CustomerDaoIml implements CustomerDao {

//    @PersistenceContext(unitName = "persistenceCustomerUnit")
    @PersistenceContext(unitName = "persistenceCustomerOpenJpaUnit")
    EntityManager entityManager;

    @Override
    public void insert(CustomerEntity customer) {
        entityManager.persist(customer);
    }

    @Override
    public void update(CustomerEntity customer) {
        entityManager.merge(customer);
    }

    @Override
    public void delete(CustomerEntity customer) {
        entityManager.remove(customer);
    }

    @Override
    public List<CustomerEntity> findAll() {
//        Query query = entityManager.createNamedQuery("customerDao.listAll");
//        return (List<CustomerEntity>) query.getResultList();
        Query query = entityManager.createQuery("Select c From CustomerEntity c");
        List queryResultList = query.getResultList();
        TypedQuery<CustomerEntity> typedQuery = entityManager.createQuery("Select c From CustomerEntity c", CustomerEntity.class);
        List<CustomerEntity> typedResultList = typedQuery.getResultList();
        typedResultList.retainAll(queryResultList);
        return typedResultList;
    }

    @Override
    public CustomerEntity findById(Long id) {
        return entityManager.find(CustomerEntity.class, id);
    }
}

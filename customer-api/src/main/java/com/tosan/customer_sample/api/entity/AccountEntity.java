package com.tosan.customer_sample.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

import com.tosan.customer_sample.api.enums.AccountStatusEnum;

@Entity
@Table(name = "TBL_ACCOUNT")
public class AccountEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "TBL_ACCOUNT_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TBL_ACCOUNT_SEQ", sequenceName = "TBL_ACCOUNT_SEQ", allocationSize = 1)
    private Long id;

    @JsonBackReference
    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    private CustomerEntity customer;

    @Column(name = "ACCOUNT_NUMBER")
    private String accountNumber;

    @Column(name = "STATUS")
    @Enumerated(value = EnumType.ORDINAL)
    private AccountStatusEnum status;

    @Column(name = "AMOUNT")
    private Long amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public AccountStatusEnum getStatus() {
        return status;
    }

    public void setStatus(AccountStatusEnum status) {
        this.status = status;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}

package com.tosan.customer_sample.api.dto.account;

import com.tosan.customer_sample.api.dto.customer.CustomerResponseDto;
import com.tosan.customer_sample.api.enums.AccountStatusEnum;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="AccountResponseDto")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="accountResponseDto", namespace ="http://www.tosan.com/accountResponseDto")
public class AccountResponseDto {

    @XmlElement
    private Long accountId;

    @XmlElement
    private CustomerResponseDto customer;

    @XmlElement
    private String accountNumber;

    @XmlElement
    private AccountStatusEnum status;

    @XmlElement
    private Long amount;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public CustomerResponseDto getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerResponseDto customer) {
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

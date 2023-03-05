package com.tosan.customer_sample.api.dto.account;


import com.tosan.customer_sample.api.enums.AccountStatusEnum;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="AccountCreateRequestDto")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="accountCreateRequestDto", namespace ="http://www.tosan.com/accountCreateRequestDto")
public class AccountCreateRequestDto {

    @XmlElement
    private long customerId;

    @XmlElement
    private String accountNumber;

    @XmlElement
    private AccountStatusEnum status;

    @XmlElement
    private Long amount;

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
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

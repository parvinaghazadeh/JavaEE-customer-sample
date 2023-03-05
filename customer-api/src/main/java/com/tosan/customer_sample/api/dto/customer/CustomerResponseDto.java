package com.tosan.customer_sample.api.dto.customer;

import com.tosan.customer_sample.api.entity.AccountEntity;
import com.tosan.customer_sample.api.enums.CustomerTypeEnum;

import javax.xml.bind.annotation.*;
import java.util.Set;

@XmlRootElement(name ="CustomerResponseDto")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="customerResponseDto", namespace ="http://www.tosan.com/customerResponseDto")
public class CustomerResponseDto {

    @XmlElement
    private Long id;

    @XmlElement
    private String name;

    @XmlElement
    private String phone;

    @XmlElement
    private String mobile;

    @XmlElement
    private String birthDate;

    @XmlElement
    private CustomerTypeEnum customerType;

    @XmlElement
    private String nationalCode;

    @XmlElement
    @XmlElementWrapper
    private Set<AccountEntity> accountList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public CustomerTypeEnum getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeEnum customerType) {
        this.customerType = customerType;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public Set<AccountEntity> getAccountList() {
        return accountList;
    }

    public void setAccountList(Set<AccountEntity> accountList) {
        this.accountList = accountList;
    }
}

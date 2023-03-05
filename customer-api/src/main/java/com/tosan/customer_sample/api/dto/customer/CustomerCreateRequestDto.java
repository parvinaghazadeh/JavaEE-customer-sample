package com.tosan.customer_sample.api.dto.customer;

import com.tosan.customer_sample.api.enums.CustomerTypeEnum;

import javax.xml.bind.annotation.*;

@XmlRootElement(name ="CustomerCreateRequestDto")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name ="customerCreateRequestDto", namespace ="http://www.tosan.com/customerCreateRequestDto")
public class CustomerCreateRequestDto {

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElement
    private String phone;

    @XmlElement
    private String mobile;

    @XmlElement
    private String birthDate;

    @XmlElement
    private CustomerTypeEnum customerType;

    private String nationalCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}

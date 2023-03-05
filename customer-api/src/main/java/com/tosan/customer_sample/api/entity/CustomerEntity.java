package com.tosan.customer_sample.api.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.tosan.customer_sample.api.enums.CustomerTypeEnum;

@Entity
@Table(name = "TBL_CUSTOMER")
public class CustomerEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator="TBL_CUSTOMER_SEQ", strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="TBL_CUSTOMER_SEQ", sequenceName="TBL_CUSTOMER_SEQ", allocationSize=1)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @Column(name = "CUSTOMER_TYPE")
    @Enumerated(value = EnumType.ORDINAL)
    private CustomerTypeEnum customerType;

    @Column(name="NATIONAL_CODE")
    private String nationalCode;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<AccountEntity> accountList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Set<AccountEntity> getAccountList() {
        return accountList;
    }

    public void setAccountList(Set<AccountEntity> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", customerType=" + customerType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

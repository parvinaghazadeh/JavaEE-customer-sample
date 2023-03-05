package com.tosan.customer_sample.api.enums;

public enum CustomerTypeEnum {
    REAL(1),
    LEGAL(2);

    private final Integer id;

    CustomerTypeEnum(Integer id) {
        this.id = id;
    }

}

package com.tosan.customer_sample.api.enums;

public enum AccountStatusEnum {
    ACTIVE(1),
    INACTIVE(2),
    BLOCKED(3);

    private final Integer id;

    AccountStatusEnum(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public static AccountStatusEnum getById(String name)
    {
        return AccountStatusEnum.valueOf(name);
    }
}

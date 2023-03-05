package com.tosan.customer_sample.core.mapper;

import com.tosan.customer_sample.api.dto.account.AccountCreateRequestDto;
import com.tosan.customer_sample.api.dto.account.AccountResponseDto;
import com.tosan.customer_sample.api.dto.account.AccountUpdateRequestDto;
import com.tosan.customer_sample.api.entity.AccountEntity;
import com.tosan.customer_sample.api.entity.CustomerEntity;
import com.tosan.customer_sample.api.enums.AccountStatusEnum;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class AccountMapper {

    public AccountResponseDto map(AccountEntity accountEntity) {
        AccountResponseDto responseDto = new AccountResponseDto();
        responseDto.setAccountId(accountEntity.getId());
        responseDto.setAccountNumber(accountEntity.getAccountNumber());
        responseDto.setStatus(accountEntity.getStatus());
        responseDto.setAmount(accountEntity.getAmount());
        responseDto.setAccountNumber(accountEntity.getAccountNumber());
        return responseDto;
    }

    public List<AccountResponseDto> map(List<AccountEntity> accountEntityList) {
        List<AccountResponseDto> result = new ArrayList<>();
        for (AccountEntity accountEntity : accountEntityList) {
            result.add(map(accountEntity));
        }
        return result;
    }

    public AccountEntity map(AccountCreateRequestDto accountRequest, CustomerEntity customer) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(accountRequest.getAccountNumber());
        accountEntity.setStatus(AccountStatusEnum.getById(accountRequest.getStatus().name()));
        accountEntity.setAmount(accountRequest.getAmount());
        accountEntity.setCustomer(customer);
        return accountEntity;
    }

    public AccountEntity map(AccountUpdateRequestDto accountRequest, CustomerEntity customer) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNumber(accountRequest.getAccountNumber());
        accountEntity.setStatus(AccountStatusEnum.getById(accountRequest.getStatus().name()));
        accountEntity.setAmount(accountRequest.getAmount());
        accountEntity.setCustomer(customer);
        return accountEntity;
    }

}

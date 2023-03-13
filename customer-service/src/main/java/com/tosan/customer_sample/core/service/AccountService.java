package com.tosan.customer_sample.core.service;

import com.tosan.customer_sample.api.dto.account.AccountCreateRequestDto;
import com.tosan.customer_sample.api.dto.account.AccountResponseDto;
import com.tosan.customer_sample.api.dto.account.AccountUpdateRequestDto;
import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.core.exception.AccountIdNullException;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccountService {

    ResponseDto<AccountResponseDto> getAccount(Long accountId) throws AccountIdNullException;

    List<AccountResponseDto> getAllAccounts();

    ResponseDto createAccount(AccountCreateRequestDto accountRequest);

    ResponseDto updateAccount(AccountUpdateRequestDto accountRequest);

    ResponseDto deleteAccount(long accountId);

}

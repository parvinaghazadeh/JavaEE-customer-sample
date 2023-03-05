package com.tosan.customer_sample.core.service;

import com.tosan.customer_sample.api.dto.account.AccountCreateRequestDto;
import com.tosan.customer_sample.api.dto.account.AccountResponseDto;
import com.tosan.customer_sample.api.dto.account.AccountUpdateRequestDto;
import com.tosan.customer_sample.api.dto.base.ResponseDto;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccountService {

    ResponseDto<AccountResponseDto> getAccount(long accountId);

    List<AccountResponseDto> getAllAccounts();

    ResponseDto createAccount(AccountCreateRequestDto accountRequest);

    ResponseDto updateAccount(AccountUpdateRequestDto accountRequest);

    ResponseDto deleteAccount(long accountId);

}

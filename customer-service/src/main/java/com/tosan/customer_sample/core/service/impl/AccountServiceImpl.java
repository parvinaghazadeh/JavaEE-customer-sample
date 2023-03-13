package com.tosan.customer_sample.core.service.impl;

import com.tosan.customer_sample.api.dto.account.AccountCreateRequestDto;
import com.tosan.customer_sample.api.dto.account.AccountResponseDto;
import com.tosan.customer_sample.api.dto.account.AccountUpdateRequestDto;
import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.api.entity.AccountEntity;
import com.tosan.customer_sample.api.entity.CustomerEntity;
import com.tosan.customer_sample.core.exception.AccountIdNullException;
import com.tosan.customer_sample.core.mapper.AccountMapper;
import com.tosan.customer_sample.core.service.AccountService;
import com.tosan.customer_sample.dao.AccountDao;
import com.tosan.customer_sample.dao.CustomerDao;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;
import java.util.Objects;

@Stateless
@WebService(name ="AccountServiceImpl", portName = "AccountServicePort", serviceName ="AccountFacadeImpl"
        , targetNamespace ="http://www.tosan.com/account")
public class AccountServiceImpl implements AccountService {

    @Inject
    private AccountDao accountDao;

    @Inject
    private CustomerDao customerDao;

    @Inject
    private AccountMapper accountMapper;

    @Override
    public ResponseDto<AccountResponseDto> getAccount (Long accountId) throws AccountIdNullException {
        if (Objects.isNull(accountId)) {
            throw new AccountIdNullException("AccountId is empty!", 600);
        }

        AccountEntity accountEntity = accountDao.findById(accountId);

        if (Objects.isNull(accountEntity)) {
            return new ResponseDto("not found any item!", "404", null);
        }
        else {
            return new ResponseDto("ok", "200", accountMapper.map(accountEntity));
        }
    }

    @Override
    public List<AccountResponseDto> getAllAccounts() {
        List<AccountEntity> accountList = accountDao.findAll();
        return accountMapper.map(accountList);
    }

    @Override
    public ResponseDto createAccount(AccountCreateRequestDto accountRequest) {
        CustomerEntity customer = customerDao.findById(accountRequest.getCustomerId());
        accountDao.insert(accountMapper.map(accountRequest, customer));
        return new ResponseDto("ok", "200", null);
    }

    @Override
    public ResponseDto updateAccount(AccountUpdateRequestDto accountRequest) {
        CustomerEntity customer = customerDao.findById(accountRequest.getCustomerId());
        accountDao.update(accountMapper.map(accountRequest, customer));
        return new ResponseDto("ok", "200", null);
    }

    @Override
    public ResponseDto deleteAccount(long accountId) {
        accountDao.delete(accountId);
        return new ResponseDto("ok", "200", null);
    }
}

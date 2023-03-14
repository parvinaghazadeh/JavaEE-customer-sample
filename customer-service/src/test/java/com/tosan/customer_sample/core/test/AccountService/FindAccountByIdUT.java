package com.tosan.customer_sample.core.test.AccountService;

import com.tosan.customer_sample.api.dto.account.AccountResponseDto;
import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.api.entity.AccountEntity;
import com.tosan.customer_sample.core.exception.AccountIdNullException;
import com.tosan.customer_sample.core.mapper.AccountMapper;
import com.tosan.customer_sample.core.service.AccountService;
import com.tosan.customer_sample.core.service.impl.AccountServiceImpl;
import com.tosan.customer_sample.dao.AccountDao;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FindAccountByIdUT /*extends BaseUnitTestCase*/ {

    @Mock
    private AccountDao accountDao;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountService accountService = new AccountServiceImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test (expected = AccountIdNullException.class)
    public void FindAccountById_isNullAccountId_ExceptionThrown() throws AccountIdNullException {
//        thrown.expect(AccountIdNullException.class);
//        thrown.expectMessage(is("AccountId is empty!"));
//        thrown.expect(hasProperty("errorCode"));  //make sure getters n setters are defined.
//        thrown.expect(hasProperty("errorCode", is(600)));

        AccountService accountService = new AccountServiceImpl();
        accountService.getAccount(null);
    }

    @Test
    public void FindAccountById_found_SuccessScenario() throws AccountIdNullException {
        doAnswer(new Answer<AccountEntity>() {
            public AccountEntity answer(InvocationOnMock invocationOnMock) throws Throwable {
                AccountEntity accountEntity = new AccountEntity();
                return accountEntity;
            }
        }).when(accountDao).findById(anyLong());

        ResponseDto<AccountResponseDto> responseDto = accountService.getAccount(42L);

        assertThat(responseDto, hasProperty("status", is("200")));
    }

    @Test
    public void FindAccountById_notFound_SuccessScenario() throws AccountIdNullException {
        when(accountDao.findById(anyLong())).thenReturn(null);

        ResponseDto<AccountResponseDto> responseDto = accountService.getAccount(42L);

        assertThat(responseDto, hasProperty("status", is("404")));
    }

}

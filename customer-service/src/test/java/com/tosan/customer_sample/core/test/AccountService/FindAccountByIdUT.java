package com.tosan.customer_sample.core.test.AccountService;

import com.tosan.customer_sample.api.dto.base.ResponseDto;
import com.tosan.customer_sample.core.exception.AccountIdNullException;
import com.tosan.customer_sample.core.mapper.AccountMapper;
import com.tosan.customer_sample.core.service.AccountService;
import com.tosan.customer_sample.core.service.impl.AccountServiceImpl;
import com.tosan.customer_sample.dao.AccountDao;
import com.tosan.customer_sample.dao.CustomerDao;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasProperty;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyObject;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
//@RunWith(Parameterized.class)
public class FindAccountByIdUT /*extends BaseUnitTestCase*/ {

    @Mock
    private AccountDao accountDao;

    @Mock
    private CustomerDao customerDao;

    @Mock
    private AccountMapper accountMapper;

    @InjectMocks
    private AccountService accountService = new AccountServiceImpl();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Parameterized.Parameter(value = 0)
    private long accountId;

    @Parameterized.Parameter(value = 1)
    private boolean expected;

    @Parameterized.Parameters(name = "{index}: getAccountById({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, false},
                {42, true},
                {43, true},
                {555, false},
                {666, false}
        });
    }

    @Test
    public void FindAccountById_isNullAccountId_ExceptionThrown() throws AccountIdNullException {
        thrown.expect(AccountIdNullException.class);
//        thrown.expectMessage(is("AccountId is empty!"));
//        thrown.expect(hasProperty("errorCode"));  //make sure getters n setters are defined.
//        thrown.expect(hasProperty("errorCode", is(600)));

        AccountService accountService = new AccountServiceImpl();
        accountService.getAccount(null);
    }

    @Test //(expected = NullPointerException.class)
    public void FindAccountById_NotFound_ExceptionThrown() {
        try {
            accountService.getAccount(42L);
//            when(accountService.getAccount(anyLong())).thenReturn(any(ResponseDto.class));
//            doThrow(new RuntimeException()).when(accountService).getAccount(anyLong());
////            verify(accountService).getAccount(contains("foo"))
            fail();
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

    @Test
    public void FindAccountById_checkFound() throws AccountIdNullException {
        try {
            when(accountService.getAccount(accountId)).thenReturn(any(ResponseDto.class));
            Assert.assertEquals(true, expected);
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

}

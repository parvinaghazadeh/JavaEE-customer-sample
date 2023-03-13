package com.tosan.customer_sample.core.test.AccountService;

import com.tosan.customer_sample.core.service.AccountService;
import com.tosan.customer_sample.core.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.fail;

@RunWith(Parameterized.class)
public class FindAccountByIdParametrized {

    @Parameter(value = 0)
    private long accountId;

    @Parameter(value = 1)
    private boolean expected;

    @Parameters(name = "{index}: getAccountById({0}) = {1}")
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
    public void FindAccountById_NotFound_ExceptionThrown() {
        try {
            AccountService accountService = new AccountServiceImpl();
            accountService.getAccount(accountId);
            fail();
        } catch (Exception e) {
            assertNull(e.getMessage());
        }
    }

}

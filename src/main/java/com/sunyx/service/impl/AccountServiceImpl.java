package com.sunyx.service.impl;

import com.sunyx.dao.AccountDao;
import com.sunyx.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/22.
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    private TransactionTemplate transactionTemplate;
    @Resource
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }
    @Resource
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(final String from, final String to, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.outMoney(from,money);
                int i = 1/0;
                accountDao.inMoney(to,money);
            }
        });

    }
}

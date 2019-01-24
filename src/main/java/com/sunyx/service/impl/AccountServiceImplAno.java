package com.sunyx.service.impl;

import com.sunyx.dao.AccountDao;
import com.sunyx.service.AccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/22.
 */
@Service("accountServiceAno")
@Transactional(rollbackFor = ClassNotFoundException.class,propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
public class AccountServiceImplAno implements AccountService {


    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }
    @Resource
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer( String from,  String to,  Double money) {
        accountDao.outMoney(from,money);
        int i = 1/0;
        accountDao.inMoney(to,money);
    }
}

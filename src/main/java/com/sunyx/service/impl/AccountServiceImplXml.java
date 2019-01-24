package com.sunyx.service.impl;

import com.sunyx.dao.AccountDao;
import com.sunyx.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/22.
 */
@Service("accountServiceXml")
public class AccountServiceImplXml implements AccountService {


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

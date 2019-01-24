package com.sunyx.dao.impl;

import com.sunyx.dao.AccountDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/22.
 */
@Repository("accountDao")
public class AccountDaoImpl implements  AccountDao {
    private JdbcTemplate jdbcTemplate;

    @Resource
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void outMoney(String name, Double money) {
        jdbcTemplate.update("UPDATE tt_account SET money = money - ? where name=?", money, name);
    }

    @Override
    public void inMoney(String name, Double money) {
        jdbcTemplate.update("UPDATE tt_account SET money = money + ? where name=?",money,name);
    }
}

package com.sunyx.dao;

/**
 * Created by liuli on 2019/1/22.
 */
public interface AccountDao {
    public void outMoney(String name ,Double money);
    public void inMoney(String name,Double money);
}

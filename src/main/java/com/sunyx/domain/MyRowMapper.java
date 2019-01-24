package com.sunyx.domain;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by liuli on 2019/1/18.
 */
public class MyRowMapper implements RowMapper<Emp> {

    @Override
    public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
        Emp emp = new Emp();
        emp.setId(resultSet.getInt("id"));
        emp.setName(resultSet.getString("name"));
        return emp;
    }
}

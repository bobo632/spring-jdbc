import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo1 {
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Test
    public void test1(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("oracle.jdbc.OracleDriver");
        driverManagerDataSource.setUrl("jdbc:oracle:thin:@10.143.24.36:1521:ACTTEST1");
        driverManagerDataSource.setUsername("ucr_param");
        driverManagerDataSource.setPassword("1qazwsxparam");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(driverManagerDataSource);
        jdbcTemplate.update("insert into t_emp(id,name) VALUES (?,?)",100,"sss");

    }
    @Test
    public void test2(){
        jdbcTemplate.update("insert into t_emp(id,name) VALUES (?,?)",920,"sss");
    }
    @Test
    public void test3(){
        jdbcTemplate.update("DELETE  FROM t_emp WHERE  id=?",920);
    }
    @Test
    public void test4(){
        jdbcTemplate.update("UPDATE  t_emp SET name=? WHERE  id=?","aaa",100);
    }
    @Test
    public void test5(){
        String name = jdbcTemplate.queryForObject("SELECT count(*) FROM t_emp",String.class,100);
        System.out.printf(name);
    }
    @Test
    public void test6(){
        Long count = jdbcTemplate.queryForObject("SELECT count(*) FROM t_emp",Long.class);
        System.out.println(count);
    }




}

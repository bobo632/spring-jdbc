import com.sunyx.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by liuli on 2019/1/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Demo2 {
    @Resource(name = "accountService")
    private AccountService accountService;
    @Resource(name = "accountServiceXml")
    private AccountService accountServiceXml;
    @Resource(name = "accountServiceAno")
    private AccountService accountServiceAno;
    @Test
    public void test1(){
        accountService.transfer("haha","hehe",100D);
    }
    @Test
    public void test2(){
        accountServiceXml.transfer("haha","hehe",100D);
    }
    @Test
    public void test3(){
        accountServiceAno.transfer("haha","hehe",100D);
    }
}

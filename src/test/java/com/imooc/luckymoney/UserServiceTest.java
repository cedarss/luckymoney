package com.imooc.luckymoney;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.imooc.luckymoney.domain.entity.UserVo;
import com.imooc.luckymoney.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: cedar
 * @Date: 2019/7/31 16:40
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    /**
     *
     * 功能描述:
     *          org.hibernate.lazyinitializationexception could not initialize proxy - no session
     *          这些异常是最后的这个异常导致的，
     *          网上找了很多，
     *          都说是jpa或hibernate的延迟加载搞的鬼，
     *          解决方法无非就是几种，
     *          分别贴出与各位分享之
     * 解决办法:
     *           在spring boot的配置文件application.properties
     *           添加spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
     *
     *
     * @param:
     * @return:
     * @auther: cedar
     * @date: 2019/7/31 17:44
     */
    @Test
    public void testGetOne(){
        UserVo userVo = userService.findUser(1);
        Assert.assertEquals("小青",userVo.getUsername());
        System.out.println(userVo.toString());
    }
}

package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.properties.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Auther: cedar
 * @Date: 2019/7/27 17:14
 * @Description:   @Controller  +  * @ResponseBody =  RestController
 */
@RestController
@RequestMapping({"hello","hi"})
public class DemoController {


    @Autowired
    private User user;
    @GetMapping({"/say/{id}","/speak/{id}"})
    public String say(@PathVariable Integer id,@RequestParam(required = false,defaultValue = "美女") String sex){
       return "你不是得到我了吗,"+user.getDescription()+"id="+id+",我是一个"+sex;
    }
}

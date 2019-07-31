package com.imooc.luckymoney.controller;

import com.imooc.luckymoney.aspect.HttpAspect;
import com.imooc.luckymoney.domain.response.Result;
import com.imooc.luckymoney.repository.UserRepository;
import com.imooc.luckymoney.domain.entity.UserVo;
import com.imooc.luckymoney.service.UserService;
import com.imooc.luckymoney.util.ResultUtil;
import org.aspectj.lang.annotation.AfterReturning;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @Auther: cedar
 * @Date: 2019/7/28 16:53
 * @Description:
 */
@RestController
public class UserController {

    public final  static Logger logger = LoggerFactory.getLogger(HttpAspect.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService uesrService;


    private UserVo userVo;

    @PostMapping("users")
    public Result list(UserVo userVo){
        Example<UserVo> queryUser = Example.of(userVo);
        return ResultUtil.success(userRepository.findAll(queryUser));
    }


    @PostMapping("pc/v1/addUser")
    public Result create(@RequestParam("username") String username,@RequestParam("age") Integer age){
        UserVo userVo = new UserVo();
        userVo.setUsername(username);
        userVo.setAge(age);
        return ResultUtil.success(userRepository.save(userVo));
    }

    @PostMapping("pc/v2/addUser")
    public Result creatObj(@Valid UserVo userVo, BindingResult result){
        //如果效验不通过
        if(result.hasErrors()){
            logger.info(result.getFieldError().getDefaultMessage());
            return ResultUtil.error(201,result.getFieldError().getDefaultMessage());
        }
        return ResultUtil.success(userRepository.save(userVo));
    }

    @GetMapping("detail/{id}")
    public Result findById(@PathVariable("id") Integer id){
        return ResultUtil.success(userRepository.findById(id).orElse(null));
    }


    @PostMapping("update/{id}")
    public Result updateById(@PathVariable("id") Integer id,@RequestParam("age") Integer age){
        Optional<UserVo> optional =  userRepository.findById(id);

        //如果查询有内容
        if(optional.isPresent()){
            UserVo user = optional.get();
            user.setAge(age);
            return ResultUtil.success(userRepository.save(user));
        }


      return null;
    }

    @GetMapping("getOne/{id}")
    public Result getOne(@NotNull @PathVariable("id") Integer id){
       userVo =  uesrService.findUser(id);
       return ResultUtil.success(userVo);
    }


}

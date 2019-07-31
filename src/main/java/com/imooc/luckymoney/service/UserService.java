package com.imooc.luckymoney.service;

import com.imooc.luckymoney.domain.entity.UserVo;
import com.imooc.luckymoney.repository.UserRepository;
import com.imooc.luckymoney.throwable.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * @Auther: cedar
 * @Date: 2019/7/31 16:24
 * @Description:
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public UserVo findUser(Integer id){
             UserVo userVo =  userRepository.getOne(id);
             if(null == userVo){
                  throw new CustomException(201,"不存在此用户");
             }else if(ObjectUtils.isEmpty(userVo.getUsername())){
                  throw new CustomException(201,"用户名称为空");
             }
             return userVo;
    }
}

package com.imooc.luckymoney.repository;

import com.imooc.luckymoney.domain.entity.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 * @Auther: cedar
 * @Date: 2019/7/28 16:55
 * @Description:
 */
@Component
public interface UserRepository extends JpaRepository<UserVo,Integer> {
}

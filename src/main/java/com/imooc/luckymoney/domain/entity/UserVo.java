package com.imooc.luckymoney.domain.entity;

import lombok.Data;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: cedar
 * @Date: 2019/7/28 16:40
 * @Description:
 */
@Entity
@Lazy(true)
public class UserVo implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    @NotEmpty(message = "名字不能为空")
    private String username;

    @Min(value=18,message = "未成年少女不能恋爱")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserVo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}

package com.imooc.luckymoney.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.sql.DataSourceDefinition;

/**
 * @Auther: cedar
 * @Date: 2019/7/27 17:26
 * @Description:
 */
@Component
@ConfigurationProperties(prefix = "user")
@Data
public class User {
    private String name;
    private Integer age;
    private String description;
}

package com.imooc.luckymoney.throwable;

/**
 * @Auther: cedar
 * @Date: 2019/7/30 23:37
 * @Description:
 */
public class CustomException extends RuntimeException {

    private Integer code;

    public CustomException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }




}

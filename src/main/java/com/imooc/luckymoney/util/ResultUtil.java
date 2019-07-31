package com.imooc.luckymoney.util;

import com.imooc.luckymoney.domain.response.Result;

/**
 * @Auther: cedar
 * @Date: 2019/7/30 18:39
 * @Description:
 */
public class ResultUtil {


    public static Result success(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(data);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setCode(200);
        result.setMsg("ok");
        result.setData(null);
        return result;
    }

    public static Result error(Integer code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(null);
        return result;
    }
}

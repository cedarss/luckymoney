package com.imooc.luckymoney.handle;

import com.imooc.luckymoney.aspect.HttpAspect;
import com.imooc.luckymoney.domain.response.Result;
import com.imooc.luckymoney.throwable.CustomException;
import com.imooc.luckymoney.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: cedar
 * @Date: 2019/7/30 22:44
 * @Description:
 */
@ControllerAdvice
public class ExceptionHandle {
    public final  static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    public Result handle(Exception e, HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Encoded", "1");

        Throwable cause = e;

        if (cause instanceof HttpMessageNotReadableException) {
            if (cause.getMessage().startsWith("Required request body")) {
                logger.warn("请求体中缺失参数: {}", cause.getMessage());
                return ResultUtil.error(201, cause.getMessage());
            } else {
                logger.warn("请求体中参数不合法: {}", cause.getMessage());
                return ResultUtil.error(201, cause.getMessage());
            }
        } else if (cause instanceof HttpMessageConversionException) {
            logger.warn("请求参数转换失败: {}", cause.getMessage());
            return ResultUtil.error(201, cause.getMessage());
        } else if (cause instanceof HttpMediaTypeNotSupportedException) {
            logger.warn("不支持的请求参数类型: {}", ((HttpMediaTypeNotSupportedException) cause).getContentType());
            return ResultUtil.error(201, cause.getMessage());
        }else if(cause instanceof CustomException){
            return ResultUtil.error(((CustomException) cause).getCode(),cause.getMessage());
        }

        return ResultUtil.error(201,e.getMessage());
    }
}

package com.bupt.servicebase.handler;
import com.bupt.commonutils.R;
import com.bupt.servicebase.exception.EduException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j//lombok中的注解，用于日志相关操作
public class GlobalExceptionHandler {

    //指定出现什么异常执行这个方法
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public R error(Exception e) {
        e.printStackTrace();
        return R.error().message("执行了全局异常处理..");
    }

    //特定异常
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody //为了返回数据
    public R error(ArithmeticException e) {
        e.printStackTrace();
        return R.error().message("执行了ArithmeticException异常处理..");
    }

    //自定义异常
    @ExceptionHandler(EduException.class)
    @ResponseBody //为了返回数据
    public R error(EduException e) {
        log.error("错误信息:",e.getMessage());
        e.printStackTrace();//log.error好像已经有了该行代码的功能

        return R.error().code(e.getCode()).message(e.getMsg());
    }
}

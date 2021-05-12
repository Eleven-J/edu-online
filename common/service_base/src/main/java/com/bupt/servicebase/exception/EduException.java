package com.bupt.servicebase.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//lombok插件的注解，用于自动隐式生成构造方法，当然也可以自己写构造方法
@AllArgsConstructor  //生成有参数构造方法
@NoArgsConstructor   //生成无参数构造
public class EduException extends RuntimeException {
    private Integer code;//状态码
    private String msg;//异常信息
}

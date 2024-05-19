package com.zm.apiinterface.aop;

import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 调用次数切面
 */
@RestControllerAdvice
public class InvokeCountAOP {

    //定义切面触发的时机，controller接口的方法执行成功后，执行下述方法
    //@AfterReturning(returning = "result", pointcut = "execution(* com.zm.apiinterface.controller.*Controller.*(..))")
    public void doAfterReturning(Object result)
    {
        //获取当前用户
        //获取当前接口的调用次数
        //调用次数+1
        //更新数据库
    }
}

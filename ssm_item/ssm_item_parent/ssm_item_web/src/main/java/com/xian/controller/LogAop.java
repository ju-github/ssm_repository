package com.xian.controller;

import com.xian.domain.SysLog;
import com.xian.service.IsysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
@Aspect
public class LogAop {
    private long start;
    private long executeTime;

    private String methodAllName;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private IsysLogService logService;

    //前置通知
    @Before("execution(* com.xian.controller.*.*(..))")
    public void before(JoinPoint joinPoint){
         start = System.currentTimeMillis();
        //切入点方法的全类名
        String className = joinPoint.getTarget().getClass().getName();
        //切入点方法名称
        String mothedName = joinPoint.getSignature().getName();
        methodAllName = className + "." + mothedName;
    }

    //最后通知
    @After("execution(* com.xian.controller.*.*(..))")
    public void after(){
        long end = System.currentTimeMillis();
        //获取执行的时长
        executeTime=end-start;
        System.out.println(executeTime);
        //获取方法执行的时间
        Date date = new Date();

        System.out.println(methodAllName);

        //获取登录用户名
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        String username = user.getUsername();
        System.out.println(username);

        //获取请求的url
        String URI = request.getRequestURI();
        System.out.println(URI);

//        获取客户机ip
        String IP = request.getRemoteAddr();
        System.out.println(IP);

        //封装sysLog
        SysLog sysLog = new SysLog();
        sysLog.setExecutionTime(executeTime);
        sysLog.setIp(IP);
        sysLog.setMethod(methodAllName);
        sysLog.setUrl(URI);
        sysLog.setUsername(username);
        sysLog.setVisitTime(date);

        //调用业务层保存
        logService.save(sysLog);


    }

}

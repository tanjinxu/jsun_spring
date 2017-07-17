package cn.itcast.aop;

import java.io.PrintStream;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoginAspectj
{
  @Before("execution(* cn.itcast.service.LoginDao.login(..))")
  public void before(JoinPoint joinPoint)
  {
    System.out.println("前置增强....");
  }
}
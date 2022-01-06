package com.sing.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {



	@Before("execution(public void com.sing.service.UserService.test())")
	public void before (){
		System.out.println(" UserService test before ");
	}

	@AfterThrowing("execution(public void com.sing.service.UserService.test())")
	public void afterThrowing (){
		System.out.println(" UserService test afterThrowing ");
	}

	@AfterReturning("execution(public void com.sing.service.UserService.test())")
	public void afterReturning (){
		System.out.println(" UserService test afterReturning ");
	}

	@Around("execution(public void com.sing.service.UserService.test())")
	public void around (ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println(" UserService test around start");
		proceedingJoinPoint.proceed();
		System.out.println(" UserService test around end");
	}
	@After("execution(public void com.sing.service.UserService.test())")
	public void after (){
		System.out.println(" UserService test after ");
	}
}

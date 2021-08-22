package com.sing.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

	@Before("execution(public void com.sing.service.UserService.test())")
	public void before (){
		System.out.println(" UserService test before ");
	}

	@Before("execution(public void com.sing.service.IndexService.test())")
	public void beforeIndex (){
		System.out.println(" IndexService test before ");
	}
}

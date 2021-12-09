package com.sing.resolveBeforeInstantiation;

import org.springframework.stereotype.Component;

/**
 * @author songbo
 * @date 2021-11-20
 */
@Component
public class BeforeInstantiation {

	public void doSomething(){
		System.out.println("执行 doSomething ");
	}
}

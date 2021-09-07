package com.sing.service;

import com.mybatis.mapper.OrderMapper;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class IndexService implements InitializingBean {
	@Autowired
	@Qualifier("userServiceQ")
	UserService userService;
	// @Autowired
	// OrderMapper orderMapper;

	public IndexService(){
		// System.out.println("IndexService Constructor");
	}

	public void test(){
		// System.out.println(" IndexService test" +
		// 		userService.getFlag());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// System.out.println("IndexService afterPropertiesSet");
	}

	@PostConstruct
	public void init(){
		// System.out.println("IndexService init");
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}

package com.sing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	IndexService indexService;
	private String flag = "";

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public UserService(String str){
		this.flag = str;
	}
	public UserService(){
		// System.out.println("UserService Constructor");
	}

	public void test(){
		// System.out.println(" UserService test");
	}


}

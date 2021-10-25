package com.sing.selftag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class  UserNameSpaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("test",new UserTagBeanDefinitionParser());
	}
}

package com.sing.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class TestFactoryBean implements FactoryBean<Object> {
	@Override
	public Object getObject() throws Exception {
		return new FactoryObject();
	}

	@Override
	public Class<?> getObjectType() {
		return FactoryObject.class;
	}
}

package com.sing.context;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 继承重新context来做一些扩展
 */
public class MyClassPathXmlApplicationContext extends ClassPathXmlApplicationContext {

	public MyClassPathXmlApplicationContext(String... configLocations){
		super(configLocations);
	}

	/**
	 * 这个扩展点是在prepareRefresh()中设置活跃状态之后
	 */
	@Override
	protected void initPropertySources(){
		getEnvironment().setRequiredProperties("OS");
	}

	/**
	 * 这个扩展点是在obtainFreshBeanFactory()中refreshBeanFactory()方法中，在创建beanFactory之后，解析加载xml之前
	 * @param beanFactory the newly created bean factory for this context
	 */
	@Override
	protected void customizeBeanFactory(DefaultListableBeanFactory beanFactory){
		super.setAllowBeanDefinitionOverriding(true);
		super.setAllowCircularReferences(true);
		super.customizeBeanFactory(beanFactory);
	}

	@Override
	protected void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
		System.out.println("扩展实现 postProcessBeanFactory方法");
	}
}

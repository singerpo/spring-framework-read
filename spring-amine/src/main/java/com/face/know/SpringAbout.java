package com.face.know;

public class SpringAbout {
	/**
	 * Spring Bean的生命周期
	 * 	实例化	【获取Class对象->Constructor ctor = clazz.getDeClaredConstructor();Object obj = ctor.newInstance()】
	 * 	属性填充 【populateBean】
	 * 	初始化   【initializeBean】（
	 * 			invokeAwareMethods[BeanNameAware、BeanClassLoaderAware、BeanFactoryAware]->
	 * 			BeanPostProcessor[ApplicationContextAware等、@PostConstruct]->invokeInitMethods->
	 * 			BeanPostProcessor[Aop]）
	 * 	销毁
	 */

	/**
	 * Spring Boot  22
	 * 1.@SpringBootApplication注解解析
	 * 2.@AutoConfiguration 注解解析
	 * 3.AutoConfigurationImportSelector解析
	 * 4.spring.factories 配置文件的解析过程
	 * 5.@Import标签的解析过程分析
	 * 6.Spring Boot 启动流程如何扫描对应的主机
	 * 7.Spring Boot自动装配原理总结
	 */
}

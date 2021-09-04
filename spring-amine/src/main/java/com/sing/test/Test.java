package com.sing.test;

import com.mybatis.SingMapperFactoryBean;
import com.mybatis.mapper.UserMapper;
import com.sing.app.Appconfig;
import com.sing.beanFactoryPostProcessor.TestBfp;
import com.sing.service.IndexService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.nio.file.Files;

public class Test {

	// public static void main(String[] args) {
	// 	FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\spring-framework-read\\spring-amine\\src\\main\\resources\\spring.xml");
	// 	IndexService indexService = applicationContext.getBean(IndexService.class);
	// 	System.out.println(indexService);
	// 	indexService.test();
	// }

	public static void main(String[] args) {
//		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("");
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(Appconfig.class);
		applicationContext.refresh();
//		IndexService indexService = applicationContext.getBean(IndexService.class);
//		indexService.test();
// 		System.out.println(applicationContext.getBean("userMapper"));
// 		System.out.println(applicationContext.getBean("&userMapper"));
		System.out.println(applicationContext.getBean("&testFactoryBean"));
		System.out.println(applicationContext.getBean("testFactoryBean"));
// 		TestBfp testBfp = applicationContext.getBean(TestBfp.class);
// 		testBfp.test();

	}
}

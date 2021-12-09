package com.sing.test;

import com.sing.app.Appconfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {

	// public static void main(String[] args) {
	// 	FileSystemXmlApplicationContext applicationContext = new FileSystemXmlApplicationContext("E:\\spring-framework-read\\spring-amine\\src\\main\\resources\\spring.xml");
	// 	IndexService indexService = applicationContext.getBean(IndexService.class);
	// 	System.out.println(indexService);
	// 	indexService.test();
	// }

	public static void main(String[] args) {
		// ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext("spring.xml");
 		 AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		 applicationContext.register(Appconfig.class);
		 applicationContext.refresh();
		 // applicationContext.close();
		// IndexService indexService = applicationContext.getBean(IndexService.class);
		// indexService.test();
// 		System.out.println(applicationContext.getBean("userMapper"));
// 		System.out.println(applicationContext.getBean("&userMapper"));
// 		System.out.println(applicationContext.getBean("&testFactoryBean"));
// 		System.out.println(applicationContext.getBean("testFactoryBean"));
// 		TestBfp testBfp = applicationContext.getBean(TestBfp.class);
// 		testBfp.test();

	}
}

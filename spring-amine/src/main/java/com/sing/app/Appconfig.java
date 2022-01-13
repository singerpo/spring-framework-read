package com.sing.app;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.mybatis.SingImportBeanDefinitionRegistrar;
import com.sing.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Priority;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

@ComponentScan("com.sing")
// @Import(SingImportBeanDefinitionRegistrar.class)
@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
public class Appconfig {
	// @Bean
	// @Qualifier("userServiceQ")
	// public UserService userService1(){
	// 	System.out.println("userService1");
	// 	return  new UserService("1");
	// }
	//
	// @Bean
	// @Primary
	// public  UserService userService2(){
	// 	userService1();
	// 	System.out.println("userService2");
	// 	return  new UserService("2");
	// }

	// @Bean
	// public SqlSessionFactory sqlSessionFactory() throws IOException {
	// 	System.out.println("@Bean sqlSessionFactory");
	// 	String resource = "mybatis-config.xml";
	// 	InputStream inputStream = Resources.getResourceAsStream(resource);
	// 	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	// 	return sqlSessionFactory;
	// }

}

package com.sing.app;

import com.mybatis.SingImportBeanDefinitionRegistrar;
import com.sing.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.annotation.Priority;
import java.io.IOException;
import java.io.InputStream;

@ComponentScan("com.sing")
@Import(SingImportBeanDefinitionRegistrar.class)
@EnableAspectJAutoProxy
@Configuration
public class Appconfig {
	@Bean
	@Qualifier("userServiceQ")
	public UserService userService1(){
		return  new UserService("1");
	}

	@Bean
	@Primary
	public UserService userService2(){
		return  new UserService("2");
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws IOException {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		return sqlSessionFactory;
	}

}

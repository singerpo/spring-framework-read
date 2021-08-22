package com.mybatis;

import org.mybatis.spring.annotation.MapperScannerRegistrar;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(SingImportBeanDefinitionRegistrar.class)
public @interface MyMapperScan {

	String[] value() default {};
}
